package com.scl.thread.concurrent.future;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public interface Future<T> {
    /**
     *
     * @return
     * @throws InterruptedException
     */
    T get() throws InterruptedException;
}
