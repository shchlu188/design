package com.scl.se.generic;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/11
 * @Description 枚举
 *                  使用枚举有更强的约束
 *              常用方法
 **********************************/
public class EnumDemo {
    public static void main(String[] args) {
        UserStateEnum normal = UserStateEnum.NORMAL;
        System.out.println(normal.ordinal());
        System.out.println(normal.name());
        System.out.println(UserStateEnum.valueOf("NORMAL"));

    }
    static enum UserStateEnum{
        NORMAL,LOCKED,DISABLE;
    }
}
