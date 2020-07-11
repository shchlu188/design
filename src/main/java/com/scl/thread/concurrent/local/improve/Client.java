package com.scl.thread.concurrent.local.improve;

import com.scl.thread.concurrent.local.ExecutionTask;

import java.util.stream.IntStream;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/7
 * @Description
 **********************************/
public class Client {
    public static void main(String[] args) {
        IntStream.range(0,5)
                .forEach(idx->
                        new Thread(new ExecutionThreadLocalTask()).start());
    }
}
