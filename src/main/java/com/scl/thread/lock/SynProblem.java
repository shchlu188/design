package com.scl.thread.lock;

import java.util.concurrent.TimeUnit;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/2
 * @Description
 **********************************/
public class SynProblem {
    public static void main(String[] args) {
        new Thread(SynProblem::run,"T1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(SynProblem::run,"T2");
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();
        System.out.println(t2.isInterrupted());
    }

    public  static void run(){
        System.out.println(Thread.currentThread());
        while (true){

        }
    }
}
