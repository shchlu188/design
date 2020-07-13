package com.scl.design.observer.one;

/**
 * @author scl
 * @Date 2020/6/26
 * @Description 主题
 */
public interface Subject {
    /**
     * 注册观察者
     * @param observer 观察者
     */
    void register(Observer observer);

    /**
     * 取消观察者
     * @param observer 观察者
     */
    void remove(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObserver();
}
