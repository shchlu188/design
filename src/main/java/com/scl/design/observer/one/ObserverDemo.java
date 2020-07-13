package com.scl.design.observer.one;

/**
 * @author scl
 * @Date 2020/6/26
 * @Description 测试观察者模式
 */
public class ObserverDemo {
    public static void main(String[] args) {
        // 创建主题
        Subject subject = new Sport3DSubject();
        // 创建观察者
        Observer p1 = new ObserverPerson("p1",subject);
        Observer p2 = new ObserverPerson("p2",subject);
        Observer p3 = new ObserverPerson("p3",subject);
        Sport3DSubject sport3DSubject = (Sport3DSubject) subject;
        sport3DSubject.setMessage("本期中将的号码为123");
        subject.notifyObserver();
    }
}
