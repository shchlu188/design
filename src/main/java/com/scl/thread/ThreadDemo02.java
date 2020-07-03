package com.scl.thread;

import java.util.concurrent.TimeUnit;

public class ThreadDemo02 {
    public static void main(String[] args) {
        TicketImp ticketImp = new TicketImp();
        new Bank(ticketImp).start();
        new Bank(ticketImp).start();
        new Bank(ticketImp).start();
        new Bank(ticketImp).start();
        new Bank(ticketImp).start();

    }
    static class WindowTicketEx extends Thread{
        private final int MAX = 500;
        private static int index=1;
        @Override
        public void run() {

            while (index<MAX){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" 当前号码: "+(index++));
            }

        }
    }
    static class Bank extends Thread{
        private TicketImp ticketImp;

        Bank(TicketImp ticketImp){
            this.ticketImp =ticketImp;
        }

        @Override
        public void run() {
            ticketImp.run();
        }


    }
    static class TicketImp implements Runnable{
        private int index;
        private final int MAX = 500;
        @Override
        public void run() {
            while (index<MAX){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" 当前号码: "+(index++));
            }
        }
    }
}



