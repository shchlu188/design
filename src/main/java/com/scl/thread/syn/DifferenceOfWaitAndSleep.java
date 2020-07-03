package com.scl.thread.syn;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/1
 * @Description wait and sleep method different
 * ******************
 *         wait() and sleep()
 *              1、sleep is the method of Thread,wait is the method of Object
 *              2、sleep will not release the Object monitor, but wait will and add to the Object monitor waiting queue
 *              3、sleep not depend on the monitor ,but wait need
 *              4、sleep method not need be wakeup, but wait need
 *
 *
 **********************************/
public class DifferenceOfWaitAndSleep {
    private static final Object LOCK = new Object();
    public static void main(String[] args) {

    }


    public static void m1(){
       synchronized (LOCK){
           try {
               Thread.sleep(1);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

    }

    public static void m2(){
        synchronized (LOCK){
            try {
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
