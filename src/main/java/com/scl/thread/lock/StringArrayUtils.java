package com.scl.thread.lock;

import java.util.Arrays;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/1
 * @Description 自定义字符串工具类
 **********************************/
public class StringArrayUtils {


    public static String[] genericStringArray(String prefix,int count){
        String[] result = new String[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = prefix+(i+1);
        }

        return result;
    }
}
