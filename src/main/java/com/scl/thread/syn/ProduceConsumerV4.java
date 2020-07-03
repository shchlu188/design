package com.scl.thread.syn;

import lombok.SneakyThrows;

import java.util.stream.Stream;

public class ProduceConsumerV4 {
    private int resource = 0;
    private final Object LOCK = new Object();
    private volatile boolean hasProducer = false; // 是否有产品，默认没有

    @SneakyThrows
    private void producer() {
        synchronized (LOCK) {
            // 如果没有产品
            while (!hasProducer) {
                resource++;
                System.out.println(Thread.currentThread().getName() + "----->" + resource);
                hasProducer = true;
                LOCK.notifyAll();

            }
            LOCK.wait();
        }
    }

    @SneakyThrows
    private void consumer() {
        synchronized (LOCK) {
            // 如果有产品，消费
            while (hasProducer) {

                System.out.println(Thread.currentThread().getName() + "--->" + resource);
                // 通知
                hasProducer = false;
                LOCK.notifyAll();
            }

            LOCK.wait();
        }
    }

    public static void main(String[] args) {
        ProduceConsumerV4 pc = new ProduceConsumerV4();
        Stream.of("C1", "C2").forEach(t -> {
            new Thread(() -> {
                while (true) {
                    pc.consumer();
                }
            }, t).start();
        });

        Stream.of("P1", "P2").forEach(t -> {
            new Thread(() -> {
                while (true) {
                    pc.producer();
                }
            }, t).start();
        });


    }
}
