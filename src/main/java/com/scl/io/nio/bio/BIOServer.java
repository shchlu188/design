package com.scl.io.nio.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.*;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/4
 * @Description: BIO服务端
 **********************************/
public class BIOServer {
    // 线程池机制
    public static void main(String[] args) throws IOException {
        int cpuNum = Runtime.getRuntime().availableProcessors();
        //   创建线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                cpuNum,
                cpuNum * 2,
                5l,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(12),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()

        );
        //
        ServerSocket serverSocket = new ServerSocket(6666);

        while (true){

            threadPool.execute(()->{
                Socket clientSocket=null;
                try {
                    clientSocket = serverSocket.accept();
                    handler(clientSocket);
                } catch (IOException e) {
                   e.printStackTrace();
                }
            });


        }


    }

    private static void handler(Socket socket) {
        try {
            byte[] bufs = new byte[1024];
            InputStream clientIns = socket.getInputStream();
            System.out.println(socket.getInetAddress());
            while (true){
                int read = clientIns.read(bufs);
                if (read!=-1){
                    System.out.println(new String(bufs,0,read));
                }else {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(socket+" 断开连接");
            try {
                socket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }
}
