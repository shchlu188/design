package com.scl.thread.concurrent.five;

import java.util.concurrent.TimeUnit;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class SuspensionClient {
    public static void main(String[] args) {
        RequestQueue queue = new RequestQueue();
        new ClientThread(queue,"good").start();
        ServerThread serverThread = new ServerThread(queue);
        serverThread.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        serverThread.close();

    }
}
