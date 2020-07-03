package com.scl.thread.lock;

import java.util.concurrent.TimeUnit;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/2
 * @Description
 **********************************/
public class Demo {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook((new Thread(() -> {
            System.out.println("The Application will be exit.");
            notifyAndRelease();
        })));
        int i = 0;
        while (true) {

            try {
                Thread.sleep(1_000);
                System.out.println("working...............");
            } catch (Exception e) {
                //
            }
            i++;
            if (i > 20) throw new RuntimeException("error");
        }


    }

    private static void notifyAndRelease() {
        System.out.println("notify to the admin");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("will release resources............");

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("complete...............");
    }
}
