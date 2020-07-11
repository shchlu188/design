package com.scl.design.proxy.one;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class Client {
    public static void main(String[] args) {
        ISleep sleep = new SleepProxy(new SleepReal());
        sleep.make();
    }
}
