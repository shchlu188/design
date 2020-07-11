package com.scl.thread.pc;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/9
 * @Description
 **********************************/
public class Client {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();
        new MessageProducer(messageQueue,"1").start();
        new MessageProducer(messageQueue,"2").start();
        new MessageConsumer(messageQueue,"3").start();
        new MessageConsumer(messageQueue,"4").start();
    }
}
