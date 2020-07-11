package com.scl.thread.concurrent.five;

import java.util.Random;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class ServerThread extends Thread{
    private final RequestQueue queue;

    private final Random random;
    private volatile boolean flag = false;
    public ServerThread(RequestQueue queue) {
        this.queue = queue;
        this.random =new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        while (!flag){
            Request request = queue.getRequest();
            if (request==null){
                continue;
            }
            System.out.println("server=======request:\t"+request.getMsg());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }
    public void close(){
        this.flag =true;
        this.interrupt();
    }
}
