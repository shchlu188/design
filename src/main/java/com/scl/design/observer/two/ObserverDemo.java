package com.scl.design.observer.two;

import java.util.concurrent.TimeUnit;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/4
 * @Description
 **********************************/
public class ObserverDemo {
    public static void main(String[] args) throws InterruptedException {
        Subject subject = new DefaultSubject();
        System.out.println("=========订阅subject==========");
        new OctalObserver(subject);
        new BinaryObserver(subject);
        System.out.println("=========订阅成功==========");

        System.out.println("==========发布消息1===========");
        subject.setState(2020);
        Thread.sleep(5_000);
        System.out.println("==========发布消息2===========");
        subject.setState(2021);


    }
}
