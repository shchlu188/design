package com.scl.design.observer.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @author scl
 * @Date 2020/6/26
 * @Description 3D福彩主题
 */
public class Sport3DSubject implements Subject {
    // 存储观察者的地方
    private List<Observer> observers = new ArrayList<>();
    // 发送的消息
    private String message;

    /**
     * 注册观察者，一定有存储观察者的地方
     * @param observer 观察者
     */
    @Override
    public void register(Observer observer) {
        this.observers.add(observer);
    }


    @Override
    public void remove(Observer observer) {
        // 检查观察者是否在容器中
        int index = observers.indexOf(observer);
        if (index>0){
            observers.remove(index);
        }

    }

    /**
     * 通知观察者需要具体的消息
     */
    @Override
    public void notifyObserver() {
        // 遍历观察者,发送消息
        observers.forEach(observer -> observer.updateMessage(message));
    }

    /**
     * 设置消息
     * @param message 消息
     */
    public void setMessage(String message){
        this.message = message;
    }
}
