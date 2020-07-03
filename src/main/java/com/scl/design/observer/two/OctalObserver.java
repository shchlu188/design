package com.scl.design.observer.two;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/4
 * @Description
 **********************************/
public class OctalObserver extends Observer{
    OctalObserver(Subject subject){
        this.subject =subject;
        subject.attach(this);

    }
    @Override
    void update() {
        System.out.println("Octal String: "+Integer.toOctalString(subject.getState()));
    }
}
