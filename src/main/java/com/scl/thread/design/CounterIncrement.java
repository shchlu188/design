package com.scl.thread.design;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/9
 * @Description
 **********************************/
public class CounterIncrement extends Thread {
    private volatile boolean terminated = false;
    private int count = 0;
    private Random random = new Random(System.currentTimeMillis());

    @Override
    public void run() {

        try {
            while (!terminated) {
                System.out.println(Thread.currentThread().getName() + " " + count++);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
                 System.out.println("close make interrupt");
        } finally {
            clean();
        }
    }

    public void clean() {
        System.out.println("do some clean work for  the second phase.>>" + Thread.currentThread().getName());
    }

    public void close() {
        this.terminated = true;
        this.interrupt();
    }

}
