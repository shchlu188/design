package com.scl.thread.jdk;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/9
 * @Description
 **********************************/
public class CustomCountDown {
    private final  int total;
    private volatile  int counter;
    public CustomCountDown(int total){
        this.total =total;
        this.counter=0;
    }

    public void down (){
        synchronized (this){
            this.counter++;
            this.notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (this){
            while (total != counter) {
                this.wait();
            }
            release();
        }
    }

    private void release() {
        this.notifyAll();
    }
}
