package com.scl.design.singleton;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/2
 * @Description 单例模式03
 * **************************
 *      使用双重检索机制
 **********************************/
public class SingletonObject4 {
    private  static SingletonObject4 instance;
    private SingletonObject4(){};
    // double check
    public synchronized SingletonObject4 getInstance(){
        if (null == instance){
            synchronized (SingletonObject4.class){
                if (null == instance){ // 可能导致空指针异常======>指令重排
                    instance = new SingletonObject4();
                }
            }
        }
        return SingletonObject4.instance;
    }
}
