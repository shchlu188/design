package com.scl.io.nio.bio;

import com.sun.source.tree.Scope;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/4
 * @Description
 **********************************/
public class BIOClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1",6666);
        OutputStream os = client.getOutputStream();
        os.write("hello server".getBytes());
    }
}
