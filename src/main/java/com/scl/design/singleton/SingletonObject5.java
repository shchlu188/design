package com.scl.design.singleton;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/2
 * @Description 单例模式03
 * **************************
 *      可能导致空指针异常======>指令重排
 *      解决指令重排
 **********************************/
public class SingletonObject5 {
    //    解决指令重排
    private volatile static SingletonObject5 instance;

    private SingletonObject5() {
    }


    // double check and volatile
    public  SingletonObject5 getInstance() {
        if (null == instance) {
            synchronized (SingletonObject5.class) {
                if (null == instance) { // 可能导致空指针异常======>指令重排
                    instance = new SingletonObject5();
                }
            }
        }
        return SingletonObject5.instance;
    }
}
