package com.scl.thread.concurrent.future;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description 异步
 **********************************/
public class ASynFuture<T> implements Future<T>{
    private volatile boolean done =false;
    private T result;
     public void done(T result){
         synchronized (this){
             this.result =result;
             this.done =true;
             this.notifyAll();
         }
     }
    @Override
    public T get() throws InterruptedException {
        synchronized (this){
            while (!done){
                this.wait();
            }

        }

        return result;
    }
}
