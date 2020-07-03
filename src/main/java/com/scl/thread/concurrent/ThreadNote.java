package com.scl.thread.concurrent;

import java.util.concurrent.TimeUnit;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/3
 * @Description
 *
 * 三大原则
 *      1、原子性
 *      2、可见性
 *      3、有序性
 *          1、代码执行的顺序，是按照编写的顺序从上到下执行
 *          2、unlock必须发生在lock之后
 *          3、volatile修饰的变量，写操做优先于读操作
 *          4、传递规则
 *          5、线程启动规则： start优先于run
 *          6、线程中断规则
 *          7、对象销毁规则
 *          8、线程终结原则
 * volatile:
 *      1、禁止指令重排
 *      2、强制对修改的数据写回主存
 *      3、如果是写操作，会导致其它内存中的数据失效
 *
 *  使用场景
 *      1、标记量标记
 *      2、屏障前后的一致性
 *
 **********************************/
public class ThreadNote {
    private volatile static boolean flag =false;

    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                if (flag){
                    System.out.println(Thread.currentThread().getName()+"  flag:"+flag);
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" set flag= false");
                    flag =false;
                }

            }
        },"T1").start();
        new Thread(()->{
            while (true){
                if (!flag){
                    System.out.println(Thread.currentThread().getName()+" read flag:"+flag);
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" set flag= true");
                    flag =true;
                }

            }
        },"T2").start();


    }
}
