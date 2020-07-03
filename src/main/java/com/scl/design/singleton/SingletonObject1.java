package com.scl.design.singleton;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/2
 * @Description 单例模式01
 **********************************/
public class SingletonObject1 {
    private final static SingletonObject1 INSTANCE = new SingletonObject1();
    private SingletonObject1(){};
    public SingletonObject1 getInstance(){return INSTANCE;}
}
