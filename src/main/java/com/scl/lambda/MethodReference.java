package com.scl.lambda;

import com.scl.design.strategy.StratagemOne;
import lombok.Data;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description 方法引用
 *          当传递给lambda体的操作，已经有实现的方法，就可以使用方法引用
 *
 *          三种方式
 *              对象::非静态方法
 *              类::静态方法
 *              类::非静态方法
 **********************************/
public class MethodReference {
    public static String test(String name){
        return name;
    }
    public static void main(String[] args) {
        System.out.println("=============类::非静态方法===============");
        Comparator<String> comparator = String::compareTo;
        Comparator<String> comparator2 = (s1,s2)->s1.compareTo(s2);
        System.out.println(comparator.compare("abc", "bcd"));
        UnaryOperator<String> c = s1->s1+"goof";
        System.out.println(c.apply("aasda"));


        System.out.println("=============类::静态方法===============");
        Function<String,String> function = MethodReference::test;
        String apply = function.apply("我是类::静态方法");
        System.out.println(apply);

        System.out.println("=============对象::非静态方法===============");
        Consumer<String> conStr = System.out::println;
        conStr.accept("BJ");
        System.out.println("=================");
        PrintStream ps = System.out;

        Consumer<String> conStr2 = ps::println;
        conStr2.accept("我是ps::println");

        System.out.println("====================");
        Person person =new Person();
        Consumer<String> conPer = person::setName;
        conPer.accept("zs");
        System.out.println(person);



    }

}
@Data
class Person{
    private String name;
    private String addr;


}