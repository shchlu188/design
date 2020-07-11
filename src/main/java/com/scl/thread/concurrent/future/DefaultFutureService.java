package com.scl.thread.concurrent.future;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class DefaultFutureService extends FutureService{
    @Override
    protected <T> Future<T> submit(FutureTask<T> task) throws InterruptedException {
        return super.submit(task);
    }
}
