package com.scl.io.socket.udp;

import java.io.IOException;
import java.net.*;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class UdpSender {
    public static void main(String[] args) throws IOException {
        DatagramSocket sendSocket = new DatagramSocket();
        String sendMsg = "你好，我是 UdpSender";

        DatagramPacket packet = new DatagramPacket(sendMsg.getBytes(),0,
                sendMsg.length(),
                new InetSocketAddress("127.0.0.1",9999)
                );
        sendSocket.send(packet);
    }
}
