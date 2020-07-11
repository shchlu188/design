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
public class MessageProducer extends Thread {
    private final MessageQueue messageQueue;
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    public MessageProducer(MessageQueue messageQueue, String seq) {
        super("PRODUCER>>" + seq);
        this.messageQueue = messageQueue;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            try {
                Message message = new Message("【PRODUCER】 produce MESSAGE");
                messageQueue.put(message);
                System.out.println("【"+Thread.currentThread().getName()+"】 send message finished");
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("【EXIT】 .........");
                break;
            }
        }
    }
}
