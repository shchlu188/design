package com.scl.relfect.one;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
@Component
public class Person {
    private String name;
    private String addr;

}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Component {

}

class DemoTest{
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;
        if (personClass.getAnnotation(Component.class)!=null){

        }

    }
}