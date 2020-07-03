package com.scl.thread.pool;

import java.util.concurrent.TimeUnit;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/2
 * @Description
 **********************************/
public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolVerion4 pool = new ThreadPoolVerion4(90);
        for (int i = 0; i < 90; i++) {
            int finalI = i;
            pool.submit(()->{
                System.out.println("The runnable "+ finalI +" is serviced by "+ Thread.currentThread().getName()+" start....");
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("The runnable "+ finalI +" is serviced by "+ Thread.currentThread().getName()+" end....");
            });
        }
//        pool.shutDown();
       /* IntStream.range(0,40)
                .forEach(i->{
                    pool.submit(()->{
                        System.out.println("The runnable "+i+"is serviced by "+ Thread.currentThread().getName()+" start....");
                        try {
                            TimeUnit.SECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("The runnable "+i+"is serviced by "+ Thread.currentThread().getName()+" end....");
                    });
                });*/
    }
}
