package com.scl.thread.concurrent.three;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class Client {
    static class WriteWorker extends Thread {
        private static final Random RANDOM = new Random(System.currentTimeMillis());
        private final ShareData shareData;
        private final String msg;

        WriteWorker(ShareData shareData, String msg) {
            this.shareData = shareData;
            this.msg = msg;
        }

        @Override
        public void run() {


            try {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " 【WRITE】" + msg);
                    shareData.writeData(msg);

                    Thread.sleep(RANDOM.nextInt(1000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class ReadWorker extends Thread {
        private final ShareData shareData;

        ReadWorker(ShareData shareData) {
            this.shareData = shareData;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String chars = shareData.readData();
                    System.out.println(Thread.currentThread().getName() + " 【READ】" +chars);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {

        ShareData shareData = new ShareData();
        IntStream.range(0,5).forEach(idx->new WriteWorker(shareData,"good").start());
        IntStream.range(0,5).forEach(idx->new ReadWorker(shareData).start());
    }

}
