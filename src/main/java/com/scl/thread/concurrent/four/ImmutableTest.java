package com.scl.thread.concurrent.four;

import java.util.List;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class ImmutableTest {
    private final int age;
    private final String name;
    private final List<String> list;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        return list;
    }

    public ImmutableTest(int age, String name, List<String> list) {
        this.age = age;
        this.name = name;
        this.list = list;
    }
}
