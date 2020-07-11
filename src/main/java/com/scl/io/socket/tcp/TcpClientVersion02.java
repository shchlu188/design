package com.scl.io.socket.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 * ******************
 *          增加客户端接收服务端的数据
 **********************************/
public class TcpClientVersion02 {
    public static void main(String[] args) throws IOException {
        System.out.println("============client--发送===============");
        System.out.println("【客户端】 与服务端建立连接");
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 6666);
        System.out.println("【客户端】 建立连接成功");
        // 获取
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("【客户端】 发送数据--》服务端");

        outputStream.write("hello tcpServer".getBytes());
        System.out.println("【客户端】 发送数据成功");
        socket.shutdownOutput();
        System.out.println("============client--接收===============");
        System.out.println("【客户端】 等待服务端数据");
        InputStream is = socket.getInputStream();
        byte[] bytes = is.readAllBytes();
        System.out.println("【客户端】 读取服务端数据：" + new String(bytes, 0, bytes.length));


        System.out.println("【客户端】 释放连接");
        // 释放连接
        is.close();

        socket.close();


    }
}
