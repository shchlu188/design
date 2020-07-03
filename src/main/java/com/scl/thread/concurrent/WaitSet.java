package com.scl.thread.concurrent;

import com.scl.thread.lock.StringArrayUtils;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/2
 * @Description
 *          所有线程都有一个 wait set ,用来存放调用了wait方法之后进入block状态线程
 *          线程执行notify之后，不一定立即执行
 *          线程从wait set 中被唤醒顺序不一定FIFO
 *          线程唤醒之后需要重新获取锁
 **********************************/
public class WaitSet {
    private final static Object LOCK = new Object();

    public static void work() throws InterruptedException {
        synchronized (LOCK){
            System.out.println("Begin..........");
            System.out.println("Thread will coming..........");
            LOCK.wait();

            System.out.println("Thread will leaving..........");


        }
    }
    public static void main(String[] args) throws InterruptedException {
        new Thread(()-> {
            try {
                work();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (LOCK){
            LOCK.notify();
        }

    }

    private static void compareThread() throws InterruptedException {
        IntStream.range(0, 10)
                .forEach(idx -> new Thread(() -> {
                    synchronized (LOCK) {
                        try {
                            Optional.of("【 " + Thread.currentThread().getName() + " 】will come to wait it").ifPresent(System.out::println);
                            LOCK.wait();
                            Optional.of("【 " + Thread.currentThread().getName() + " 】will leave to wait set").ifPresent(System.out::println);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }, String.valueOf(idx)).start());
        Thread.sleep(3_000);
        IntStream.range(0, 10)
                .forEach(idx -> {
                    synchronized (LOCK){
                        LOCK.notify();
                        try {
                            Thread.sleep(1_000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
