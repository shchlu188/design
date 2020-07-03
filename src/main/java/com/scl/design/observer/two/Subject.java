package com.scl.design.observer.two;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/4
 * @Description
 **********************************/
public interface Subject {
    /**
     * 获取状态
     * @return
     */
    int getState();

    void setState(int state);

    /**
     * 添加observer
     * @param observer
     */
    void attach(Observer observer);

    /**
     * 通知所有的Observer
     */
    void notifyAllObserver();
}
