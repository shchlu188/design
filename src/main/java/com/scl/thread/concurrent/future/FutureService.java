package com.scl.thread.concurrent.future;

import java.util.function.Consumer;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public abstract class FutureService {

    protected   <T> Future<T> submit(FutureTask<T> task) throws InterruptedException {
        ASynFuture<T> future = new ASynFuture<>();
        new Thread(()->{
            T result = task.call();
            future.done(result);
        }).start();
        return future;
    }
    protected   <T> Future<T> submit(FutureTask<T> task, Consumer<T> consumer) throws InterruptedException {
        ASynFuture<T> future = new ASynFuture<>();
        new Thread(()->{
            T result = task.call();
            future.done(result);
            consumer.accept(result);
        }).start();
        return future;
    }
}
