package com.scl.thread.exc;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/2
 * @Description 程序调用
 **********************************/
public class Test1 {
    private Test2 test2 = new Test2();

    public void test(){
        test2.test();
    }

    static class Test2{
        public void test(){
            Arrays.asList(Thread.currentThread().getStackTrace()).stream()
                    .filter(e->!e.isNativeMethod())
                    .forEach(e-> Optional.of(e.getClassName()+":"+e.getMethodName()+":"+e.getLineNumber()).ifPresent(System.out::println));
        }
    }

    public static void main(String[] args) {
        new Test1().test();

    }
}
