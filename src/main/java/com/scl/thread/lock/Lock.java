package com.scl.thread.lock;

import java.util.Collection;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/1
 * @Description 自定义锁
 **********************************/
public interface Lock {

    class TimeOutException extends Exception{
        public TimeOutException(String message){
            super(message);
        }
    }


    void lock() throws InterruptedException;
    void lock(long mills) throws InterruptedException,TimeOutException;
    void unlock();

    Collection<Thread> getBlockedThread();

    int getBlockedSize();


}
