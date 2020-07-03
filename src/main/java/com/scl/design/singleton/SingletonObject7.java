package com.scl.design.singleton;


/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/2
 * @Description 单例模式07
 * **************************
 *      枚举类
 **********************************/
public class SingletonObject7 {
    //    私有化
    private SingletonObject7() {
    }
    // 外部类主动使用才加载
    enum Singleton{
        INSTANCE;
        private final SingletonObject7 instance;
        Singleton(){
            instance = new SingletonObject7();
        }
        public static  SingletonObject7 getInstance(){
            return INSTANCE.instance;
        }
    }
    // double check and volatile
    public SingletonObject7 getInstance() {
        return Singleton.getInstance();
    }
}
