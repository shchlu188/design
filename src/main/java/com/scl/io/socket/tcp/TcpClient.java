package com.scl.io.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class TcpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("【客户端】 与服务端建立连接");
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),6666);
        System.out.println("【客户端】 建立连接成功");
        // 获取
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("【客户端】 发送数据--》服务端");

        outputStream.write("hello tcpServer".getBytes());
        System.out.println("【客户端】 发送数据成功");

        outputStream.close();
        socket.close();
        System.out.println("【客户端】 释放连接");



    }
}
