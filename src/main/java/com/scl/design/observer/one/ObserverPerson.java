package com.scl.design.observer.one;

import lombok.Data;

/**
 * @author scl
 * @Date 2020/6/26
 * @Description 购买彩票的人
 */
@Data
public class ObserverPerson implements Observer {
    /**
     * 观察者的名字
     */
    private String observerName;
    /**
     * 订阅的主题
     */
    private Subject subject;

    public ObserverPerson(String observerName, Subject subject) {
        this.observerName = observerName;
        this.subject = subject;
        // 将自己到主题上
        subject.register(this);
    }

    @Override
    public void updateMessage(String message) {
        System.out.println(observerName+"========>"+message);
    }
}
