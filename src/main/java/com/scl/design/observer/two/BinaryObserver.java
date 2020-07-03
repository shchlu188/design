package com.scl.design.observer.two;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/4
 * @Description
 **********************************/
public class BinaryObserver extends Observer {
    BinaryObserver(Subject subject){
        this.subject =subject;
        subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println("Binary String: "+Integer.toBinaryString(subject.getState()));
    }
}
