package com.scl.thread;

/**
 * @author scl
 * @Date 2020/7/1
 * @Description
 */
public class ThreadCloseDemo {
    static class Worker extends Thread{
        private volatile boolean flag = true;
        @Override
        public void run() {
            while (flag){

            }
        }

        public void close(){
            System.out.println("close");
            this.flag =false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
       Worker worker =new Worker();
        worker.start();

        Thread.sleep(10000);
        System.out.println("damoe");
        worker.close();
    }
}
