package com.scl.io.socket.udp;

import java.io.IOException;
import java.net.*;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class UdpReceiver {
    public static void main(String[] args) throws IOException {
        SocketAddress bindaddr = new InetSocketAddress("127.0.0.1",9999);
        DatagramSocket receiver = new DatagramSocket(bindaddr);
        byte[] bytes = new byte[1024];
        receiver.receive(new DatagramPacket(bytes,0,bytes.length));

        System.out.println(new String(bytes,0,bytes.length));

    }
}
