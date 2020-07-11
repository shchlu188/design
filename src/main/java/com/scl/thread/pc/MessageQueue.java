package com.scl.thread.pc;

import javax.lang.model.element.PackageElement;
import java.awt.*;
import java.util.LinkedList;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/9
 * @Description
 **********************************/
public class MessageQueue {
    private final LinkedList<Message> queue;
    private final static int DEFAULT_MAX_SIZE = 10000;
    private final int limit;
    public MessageQueue(){
        this(DEFAULT_MAX_SIZE);
    }

    public MessageQueue(int limit) {
        this.limit = limit;
        this.queue = new LinkedList<>();
    }

    public void put(Message message) throws InterruptedException {
        synchronized (queue){
            while (queue.size()>limit){
                queue.wait();
            }
            queue.addLast(message);
            queue.notifyAll();
        }
    }

    public Message take() throws InterruptedException {
        Message message =null;
        synchronized (queue){
            while (queue.isEmpty()){
                queue.wait();
            }
            message = queue.removeFirst();
            queue.notifyAll();
        }
        return message;
    }

    public int getLimit(){
        return this.limit;
    }

    public int maxSize(){
        synchronized (queue){
            return queue.size();
        }
    }
}
