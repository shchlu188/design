package com.scl.thread.concurrent.four;

import java.util.stream.IntStream;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class Client{
    public static void main(String[] args) {
        Person person =new Person("zs","gs");
        IntStream.range(0,5)
                .forEach(idx->new UserPersonThread(person).start());

    }

}
class UserPersonThread extends Thread{
        private  Person person;
        UserPersonThread(Person person){
            this.person = person;
        }

    @Override
    public void run() {

            while (true){
                System.out.println(Thread.currentThread().getName()+"【PRINT】==>"+person);
            }
    }
}

final class Person{
    private final String name;
    private final String addr;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }

    public Person(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }

}
