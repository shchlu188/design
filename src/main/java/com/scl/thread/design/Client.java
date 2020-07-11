package com.scl.thread.design;

import java.util.concurrent.TimeUnit;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/9
 * @Description
 **********************************/
public class Client {
    public static void main(String[] args) {
        CounterIncrement counterIncrement = new CounterIncrement();
        counterIncrement.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counterIncrement.close();
    }
}
