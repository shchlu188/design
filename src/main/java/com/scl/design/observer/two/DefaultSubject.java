package com.scl.design.observer.two;

import java.util.ArrayList;
import java.util.List;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/4
 * @Description
 **********************************/
public class DefaultSubject implements Subject {
    private volatile List<Observer> observers = new ArrayList<>();
    private volatile int state;

    @Override
    public void setState(int state) {
        if (this.state == state)
            return;
        this.state = state;
        notifyAllObserver();
    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyAllObserver() {
        observers.forEach(Observer::update);
    }
}
