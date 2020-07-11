package com.scl.thread.concurrent.six;

import java.util.Random;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class ThreadLocalComplexText {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal.set(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName()+"\t"+threadLocal.get());

        }, "t1");
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal.set(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName()+"\t"+threadLocal.get());

        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(Thread.currentThread().getName()+"\t"+threadLocal.get());

    }
}
