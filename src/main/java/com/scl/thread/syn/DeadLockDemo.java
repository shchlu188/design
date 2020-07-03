package com.scl.thread.syn;

/**
 * @author scl
 * @Date 2020/7/1
 * @Description 死锁
 */
public class DeadLockDemo {
    private OtherService otherService;
    DeadLockDemo(OtherService otherService){
        this.otherService = otherService;
    }
    private final Object lock = new Object();
    public void m1(){
        synchronized (lock){
            System.out.println("deadLockDemo================lock");
            otherService.m1();
            System.out.println("deadLockDemo================lock===== otherService.m1();");

        }
    }

    public static void main(String[] args) {
        OtherService otherService = new OtherService();
        DeadLockDemo deadLockDemo = new DeadLockDemo(otherService);
        otherService.setDeadLockDemo(deadLockDemo);
        new Thread(deadLockDemo::m1).start();
        new Thread(otherService::m1).start();

    }

}
class OtherService{
    private DeadLockDemo deadLockDemo;
    public void setDeadLockDemo(DeadLockDemo deadLockDemo){
        this.deadLockDemo = deadLockDemo;
    }
    private final Object lock = new Object();
    public void m1(){
        synchronized (lock){
            System.out.println("OtherService============lock");
            deadLockDemo.m1();
            System.out.println("OtherService============lock=== deadLockDemo.m1();");
        }
    }
}