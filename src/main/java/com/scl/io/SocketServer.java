package com.scl.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * @author scl
 * @Date 2020/6/26
 * @Description
 *      strace
 */
public class SocketServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("new ServerSocket(8080);");
        Socket client = serverSocket.accept();

        System.out.println("client:\t"+client.getPort());
        new Thread(new Runnable() {
            Socket ss;

            public Runnable setSs(Socket ss) {
                this.ss = ss;
                return this;
            }

            @Override
            public void run() {
                InputStream is = null;
                try {

                    is = ss.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                    while (true){

                        System.out.println(bufferedReader.readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
