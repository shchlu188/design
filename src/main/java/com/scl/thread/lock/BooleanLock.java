package com.scl.thread.lock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/1
 * @Description
 **********************************/
public class BooleanLock implements Lock {
    // the initValue is true indicated(表明) the lock have be get
    // the initValue is false indicated(表明) the lock is free (other thead can get it)
    private boolean initValue;

    private Collection<Thread> blockedThreadCollection = new ArrayList<>();

    private Thread currentThread;

    BooleanLock() {
        this.initValue = false;
    }

    @Override
    public synchronized void lock() throws InterruptedException {

        while (initValue) {
            // lock have be get,so that the currentThread is saved to blockedThreadCollection
            blockedThreadCollection.add(Thread.currentThread());
            // wait lock free
            this.wait();
        }
        blockedThreadCollection.remove(Thread.currentThread());
        this.initValue = true;
        this.currentThread = Thread.currentThread();
    }


    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {
        if (mills<=0){
            lock();
        }else {
            long hasRemaining = mills;
            long endTime= System.currentTimeMillis()+mills;
            while (initValue) {

                if (hasRemaining<=0){
                        throw new TimeOutException("time out");
                }
                blockedThreadCollection.add(Thread.currentThread());
                this.wait(mills);
                hasRemaining = endTime-System.currentTimeMillis();
            }
            this.initValue=true;
            this.currentThread = Thread.currentThread();
        }
    }

    @Override
    public synchronized void unlock() {
        if (Thread.currentThread() == currentThread) {
            this.initValue = false;
            Optional.of(Thread.currentThread().getName() + " release the lock monitor.")
                    .ifPresent(System.out::println);

            this.notifyAll();
        }
    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return Collections.unmodifiableCollection(blockedThreadCollection);
    }

    @Override
    public int getBlockedSize() {
        return blockedThreadCollection.size();
    }
}
