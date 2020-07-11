package com.scl.io.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 * *****************
 *          增加服务自动回复
 **********************************/
public class TcpServerVersion03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("【服务端】：准备接收数据");
        Socket accept = serverSocket.accept();
        InputStream is = accept.getInputStream();
        System.out.println("【服务端】：准备读取数据");

        byte[] bytes = is.readAllBytes();
        System.out.println("【服务端】：数据==》" + new String(bytes, 0, bytes.length));
        accept.shutdownInput();

        System.out.println("=============【服务端】==>client===============");
        OutputStream os = accept.getOutputStream();

        System.out.println("=============【服务端】向客户端发送数据===============");
        os.write("收到数据，来自服务端的回应".getBytes());


        os.close();
        is.close();
        serverSocket.close();

    }
}
