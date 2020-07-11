package com.scl.thread.design;

import lombok.SneakyThrows;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/9
 * @Description
 **********************************/
public class AppServer extends Thread {
    private int port;
    private static final int DEFAULT_PORT = 12722;
    private volatile boolean start = true;

    private List<ClientHandler> clientHandlers = new ArrayList<>();

    private ExecutorService executor = Executors.newFixedThreadPool(5);


    AppServer() {
        this(DEFAULT_PORT);
    }

    public AppServer(int port) {
        this.port = port;
    }

    @SneakyThrows
    @Override
    public void run() {
        ServerSocket serverSocket = new ServerSocket(port);
        try {
            while (start) {
                Socket accept = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(accept);
                executor.submit(clientHandler);
                this.clientHandlers.add(clientHandler);

            }
        } finally {
            this.dispose();
        }


    }

    private void dispose() {
        clientHandlers.forEach(ClientHandler::stop);
        this.executor.shutdown();
    }


    public void shutDown() {
        this.start = false;
        this.interrupt();
    }

    private class ClientHandler implements Runnable {
        private final Socket client;
        private volatile boolean running =false;

        public ClientHandler(Socket client) {
            this.client = client;
        }


        @Override
        public void run() {
            try {
                InputStream inputStream = client.getInputStream();
                OutputStream outputStream = client.getOutputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                PrintWriter pw = new PrintWriter(outputStream);
                while (running){
                    String line = br.readLine();
                    if (line==null){
                        break;
                    }
                    pw.println(line);
                    pw.flush();
                }
            } catch (IOException e) {
                this.running =false;
            }finally {
                this.stop();
            }
        }
        public void stop() {
            if (this.running){
                return;
            }
            this.running =false;
            try {
                this.client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
