package com.scl.design.singleton;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/2
 * @Description 单例模式02
 * **************
 *      会产生线程安全问题
 **********************************/
public class SingletonObject2 {
    private  static SingletonObject2 instance;
    private SingletonObject2(){};
    public SingletonObject2 getInstance(){
        if (null == instance){ // 此处会出现多线程并发问题
            instance = new SingletonObject2();
        }
        return SingletonObject2.instance;
    }
}
