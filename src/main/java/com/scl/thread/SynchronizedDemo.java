package com.scl.thread;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author scl
 * @Date 2020/7/1
 * @Description
 */
public class SynchronizedDemo {
    static class Resources implements  Runnable{
        private static final int MAX =50;
        private int index;
        private static final Object MONITOR= new Object();
        @Override
        public void run() {
            while (true){
                synchronized (MONITOR){
                    if (index>MAX){
                        break;
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"的号码:\t"+(index++));
                }
            }
        }
    }

    public static void main(String[] args) {
        Resources resources = new Resources();
        for (int i = 0; i < 5; i++) {
            new Thread(resources).start();
        }


    }
}
