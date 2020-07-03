package com.scl.design.singleton;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/2
 * @Description 单例模式03
 * **************************
 *      静态内部类
 **********************************/
public class SingletonObject6 {
    //    私有化
    private SingletonObject6() {
    }
    // 外部类主动使用才加载
    private static class InstanceHolder{
        private final static SingletonObject6 INSTANCE = new SingletonObject6();
    }
    // double check and volatile
    public  SingletonObject6 getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
