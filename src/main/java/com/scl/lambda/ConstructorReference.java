package com.scl.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.checkerframework.checker.fenum.qual.FenumUnqualified;

import java.util.function.Function;
import java.util.function.Supplier;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description 构造器引用
 *
 **********************************/
public class ConstructorReference {
    public static void main(String[] args) {
//        Supplier<String> newStr = ()->new String();
        Supplier<String> newStr = String::new;
        System.out.println(newStr.get());

        Function<String,Per> creator = Per::new;
        System.out.println(creator.apply("zzs"));


        Function<Integer,Per> p1 = Per::new;
        System.out.println(p1.apply(123));

        Function<Integer,String[]> s = String[]::new;
        String[] apply = s.apply(12);
        System.out.println(apply.length);

    }
    static class Per{
        Integer id;
        String name;
        String addr;
        Per(int id){
            this.id = id;
        }
        public Per(String name, String addr) {
            this.name = name;
            this.addr = addr;
        }

        Per(String name){
            this.name =name;
        }

        @Override
        public String toString() {
            return "Per{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", addr='" + addr + '\'' +
                    '}';
        }
    }
}
