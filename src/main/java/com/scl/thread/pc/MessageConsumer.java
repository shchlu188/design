package com.scl.thread.pc;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/9
 * @Description
 **********************************/
public class MessageConsumer extends Thread {
    private final MessageQueue messageQueue;
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    public MessageConsumer(MessageQueue messageQueue, String seq) {
        super("【CONSUMER】 " + seq);
        this.messageQueue = messageQueue;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            try {
                Message take = messageQueue.take();
                System.out.println(Thread.currentThread().getName()+" receive message:"+take.getData());
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("【EXIT】 .........");
                break;
            }
        }
    }
}
