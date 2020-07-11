package com.scl.thread.concurrent.three;

import java.util.concurrent.TimeUnit;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description 共享数据
 **********************************/
public class ShareData {
    private volatile String data;
    private final ReadWriteDemo lock = new ReadWriteDemo();
    ShareData(){

    }
    ShareData(String data){
        this.data = data;
    }

    public String readData() throws InterruptedException{
        try {
            lock.readLock();
            return doRead();
        }finally {
            lock.readUnLock();
        }
    }

    private String  doRead() {
        return data;

    }

    private void slowly(int secs) {
        try {
            TimeUnit.SECONDS.sleep(secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void writeData(String data) throws InterruptedException{

        try {
            lock.writeLock();

            doWrite(data);


        }finally {
            lock.writeUnLock();
        }
    }

    private void doWrite(String data) {

       this.data = data;
    }
}
