package com.scl.thread;

/**
 * @author scl
 * @Date 2020/7/1
 * @Description 线程demo
 *  线程的特点:
 *    1、priority(优先级) : 优先级高的先执行
 *    2、新的线程的优先级和是否为守护线程是根据创建它的线程一致
 *
 *  出现以下情况，JVM停止执行：
 *      1、调用Runtime的exit()方法
 *      2、所有非守护线程执行完成
 *
 *  创建线程的方式:
 *      1、继承Thread类
 *      2、实现Runnable接口
 *
 *
 *
 */
class PrimeThread extends Thread {
    long minPrime;
    PrimeThread(long minPrime) {
        this.minPrime = minPrime;
    }
    public void run() {
        // compute primes larger than minPrime
        System.out.println(Thread.currentThread().getName()+"  compute primes larger than minPrime");
    }
}
class PrimeRun implements Runnable {
    long minPrime;
    PrimeRun(long minPrime) {
        this.minPrime = minPrime;
    }
    public void run() {
        // compute primes larger than minPrime
        System.out.println(Thread.currentThread().getName()+"  PrimeRun compute primes larger than minPrime");

    }
}
public class ThreadDemo {
    public static void main(String[] args) {
      new PrimeThread(32).start();

        PrimeRun p = new PrimeRun(143);
        new Thread(p).start();
    }
}
