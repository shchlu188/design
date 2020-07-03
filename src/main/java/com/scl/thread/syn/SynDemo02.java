package com.scl.thread.syn;

import java.util.concurrent.TimeUnit;

/**
 * @author scl
 * @Date 2020/7/1
 * @Description
 */
public class SynDemo02 {
    public static void main(String[] args) {
        TickLock lock = new TickLock();
        TickLock lock2 = new TickLock();
        Thread t1 = new Thread(() -> {
            lock.m1();
        }, "T1");
        Thread t2 = new Thread(() -> {
            lock.m2();
        }, "T2");
        t1.start();
        t2.start();
    }

}

/**
 *  两个都不加: 同时输出
 *  加一个: 锁对象
 */
class TickLock {
    public  synchronized void m1(){
        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public  synchronized void m2(){
        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}