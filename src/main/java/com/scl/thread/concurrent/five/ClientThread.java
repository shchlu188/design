package com.scl.thread.concurrent.five;

import java.util.Random;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class ClientThread extends Thread{
    private final RequestQueue requestQueue;
    private final Random random;
    private final String sendMsg;

    public ClientThread(RequestQueue requestQueue,String sendMsg) {
        this.requestQueue = requestQueue;
        this.random =new Random(System.currentTimeMillis());
        this.sendMsg = sendMsg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("client===>request:\t"+sendMsg);
            requestQueue.putRequest(new Request(sendMsg));
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
