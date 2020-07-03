package com.scl.thread.exc;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/2
 * @Description
 **********************************/
public class ThreadException {
    public static final int A =10;
    public static final int B = 0;
    public static void main(String[] args) {

        Thread t = new Thread(()->{
            try {
                Thread.sleep(5_000);
                int res = A/B;
                System.out.println(res);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // 捕获线程异常
        t.setUncaughtExceptionHandler((thread,e)->{
            System.out.println(thread);
            System.out.println(e);
        });
        t.start();
    }
}
