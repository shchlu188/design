package com.scl.thread.gr;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/2
 * @Description
 **********************************/
public class ThreadGroupCreate {
    public static void main(String[] args) {
        ThreadGroup tg1 = new ThreadGroup("tg1");
        Thread t1 = new Thread(tg1, () -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        ThreadGroup tg2 = new ThreadGroup("tg2");
        new Thread(tg2,()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("*************************");
        Thread[] ts1 = new Thread[10];
        tg1.enumerate(ts1);
        Arrays.stream(ts1)
                .filter(Objects::nonNull)
                .forEach(System.out::println);

        System.out.println("**********false***********");
        ts1 = new Thread[10];
        Thread.currentThread().getThreadGroup().enumerate(ts1,false);
        Arrays.stream(ts1)
                .filter(Objects::nonNull)
                .forEach(System.out::println);
        System.out.println("**********true***********");
        ts1 = new Thread[10];
        Thread.currentThread().getThreadGroup().enumerate(ts1,true);
        Arrays.stream(ts1)
                .filter(Objects::nonNull)
                .forEach(System.out::println);

        System.out.println(tg1.isDestroyed());
        tg1.destroy();
        tg1.checkAccess();
        System.out.println(tg1.isDestroyed());
    }
}
