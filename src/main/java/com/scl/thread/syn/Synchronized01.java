package com.scl.thread.syn;

import lombok.SneakyThrows;

/**
 * @author scl
 * @Date 2020/7/1
 * @Description
 */
public class Synchronized01 {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {

                Thread.sleep(100_000);
            }
        };
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
