package com.scl.design.singleton;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/2
 * @Description 单例模式03
 * **************************
 *      解决多线程并发问题
 **********************************/
public class SingletonObject3 {
    private  static SingletonObject3 instance;
    private SingletonObject3(){};
    public synchronized SingletonObject3 getInstance(){ // 性能影响太高
        if (null == instance){ // 此处会出现多线程并发问题
            instance = new SingletonObject3();
        }
        return SingletonObject3.instance;
    }
}
