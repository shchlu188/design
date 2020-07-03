package com.scl.thread.syn;

import java.util.concurrent.TimeUnit;

/**
 * @author scl
 * @Date 2020/7/1
 * @Description $1$
 */
public class ProduceConsumerV1 {
    private int resource = 1;

    private void producer(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+"===producer==>"+(resource++));
        }
    }
    private void consumer(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+"===consumer==>"+(resource--));
        }
    }

    public static void main(String[] args) {
        ProduceConsumerV1 pc = new ProduceConsumerV1();
        new Thread(()->{
            while (true){
                pc.producer();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"P").start();
        new Thread(()->{
            while (true){
                pc.consumer();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
    }
}
