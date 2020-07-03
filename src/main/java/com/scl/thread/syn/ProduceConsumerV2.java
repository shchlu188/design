package com.scl.thread.syn;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author scl
 * @Date 2020/7/1
 * @Description
 */
public class ProduceConsumerV2 {
    private int resource = 0;
    private final Object LOCK = new Object();
    private volatile boolean hasProducer = false; // 是否有产品，默认没有

    @SneakyThrows
    private void producer() {
        synchronized (LOCK) {
            // 如果没有产品
            if (!hasProducer) {
                resource++;
                System.out.println(Thread.currentThread().getName()+"=生产=>通知消费者===>消费资源\t"+resource);
                hasProducer = true;
                LOCK.notify();

            } else {
                System.out.println("生产者等待消费者消费");
                LOCK.wait();
            }

        }
    }

    @SneakyThrows
    private void consumer()  {
        synchronized (LOCK) {
            // 如果有产品，消费
            if (hasProducer) {

                System.out.println(Thread.currentThread().getName() + "==消费==通知生产者===>生产资源\t" + resource);
                // 通知
                hasProducer =false;
                LOCK.notify();
            } else {
                System.out.println("消费者等待生产者生产资源");
                LOCK.wait();
            }
        }
    }

    public static void main(String[] args) {
        ProduceConsumerV2 pc = new ProduceConsumerV2();
        new Thread(() -> {
            while (true) {
                pc.consumer();
            }
        }, "A").start();
        new Thread(() -> {
            while (true) {
                pc.producer();
            }
        }, "C").start();

    }
}
