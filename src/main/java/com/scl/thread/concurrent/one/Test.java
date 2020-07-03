package com.scl.thread.concurrent.one;

import java.util.ArrayList;
import java.util.Arrays;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/4
 * @Description
 **********************************/
public class Test {
    public static void main(String[] args) {
        new ThreadLifeCycleListener().concurrentQuery(Arrays.asList("1","2"));
    }
}
