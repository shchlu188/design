package com.scl.io.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.rmi.dgc.Lease;
import java.util.Arrays;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("【服务端】：准备接收数据");
        Socket accept = serverSocket.accept();
        InputStream is = accept.getInputStream();
        System.out.println("【服务端】：准备读取数据");

        byte[] bytes = is.readAllBytes();
        System.out.println("【服务端】：数据==》"+ new String(bytes,0, bytes.length));

        is.close();
        serverSocket.close();

    }
}
