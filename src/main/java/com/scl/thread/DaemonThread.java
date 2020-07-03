package com.scl.thread;

/**
 * @author scl
 * @Date 2020/7/1
 * @Description
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread aaaaa = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("aaaaa");
        });
        System.out.println(aaaaa.isDaemon());
//        aaaaa.setDaemon(true);
        aaaaa.start();
        System.out.println("Thread is doing");
    }
}
