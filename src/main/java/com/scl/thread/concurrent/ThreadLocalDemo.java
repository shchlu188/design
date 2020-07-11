package com.scl.thread.concurrent;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class ThreadLocalDemo {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>(){
        @Override
        protected String initialValue() {
            return "ALex";
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(threadLocal.get());
    }
}
