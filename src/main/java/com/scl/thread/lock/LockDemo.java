package com.scl.thread.lock;

import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/1
 * @Description
 **********************************/
public class LockDemo {
    public static void main(String[] args) {
        final BooleanLock booleanLock = new BooleanLock();
        String[] strs = StringArrayUtils.genericStringArray("T", 4);
        Arrays.stream(strs).forEach(name->
            new Thread(()->{
                try {
                    booleanLock.lock(2l);
                    Optional.of(Thread.currentThread().getName()+ " hold the lock monitor").ifPresent(System.out::println);
                    work();
                } catch (InterruptedException | Lock.TimeOutException e) {
                    e.printStackTrace();
                }finally {
                    booleanLock.unlock();
                }
            },name).start());

        
    }

    private static void work(){
        Optional.of(Thread.currentThread().getName()+" is working").ifPresent(System.out::println);
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
