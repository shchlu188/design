package com.scl.thread;

/**
 * @author scl
 * @Date 2020/7/1
 * @Description
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(new Task("X1", 50000l));
        Thread t2= new Thread(new Task("X2", 10000l));
        Thread t3= new Thread(new Task("X3", 15000l));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        long end = System.currentTimeMillis();
        System.out.println("execute time:\t"+(end-start));
    }


    static  class Task implements Runnable{
        private String machineName;
        private long spendTime;

        public Task(String machineName, long spendTime) {
            this.machineName = machineName;
            this.spendTime = spendTime;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(spendTime);
                System.out.println(machineName+"completed data operator and successful:"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        public String getResult(){
            return machineName+"finished";
        }
    }
}
