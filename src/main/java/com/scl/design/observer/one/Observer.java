package com.scl.design.observer.one;

/**
 * @author scl
 * @Date 2020/6/26
 * @Description 观察者
 */
public interface Observer {
    /**
     * 更新消息
     * @param message 消息
     */
    void updateMessage(String message);
}
