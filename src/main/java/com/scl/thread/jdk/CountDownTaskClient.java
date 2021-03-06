package com.scl.thread.jdk;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/9
 * @Description
 **********************************/
public class CountDownTaskClient {
    public static void main(String[] args) throws InterruptedException {
        CustomCountDown cdl = new CustomCountDown(5);
        System.out.println("准备处理多线程任务");
        IntStream.rangeClosed(0, 5)
                .forEach(idx -> new Thread(() -> {
                    System.out.println(Thread.currentThread().getName() + " is working");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cdl.down();
                }, String.valueOf(idx)).start());
        cdl.await();
        System.out.println("END......");
    }
}
