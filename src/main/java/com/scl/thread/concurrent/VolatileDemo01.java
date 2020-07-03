package com.scl.thread.concurrent;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/2
 * @Description
 **********************************/
public class VolatileDemo01 {
    private volatile static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+ " will exec loop.");
            while (count==0){

            }
            System.out.println(Thread.currentThread().getName()+" read count:"+count);
        },"READER").start();
        Thread.sleep(1_000);
        new Thread(()->{
            count=1;
            System.out.println(Thread.currentThread().getName()+" update count:"+count);
        },"WRITER").start();
        System.out.println("The result count: "+ count);
    }
}
