package com.scl.thread.concurrent.local;

import java.util.stream.IntStream;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/7
 * @Description
 **********************************/
public class Client {
    public static void main(String[] args) {
        final  ExecutionTask task = new ExecutionTask();
        IntStream.range(0,5)
                .forEach(idx->
                        new Thread(new ExecutionTask()).start());
    }
}
