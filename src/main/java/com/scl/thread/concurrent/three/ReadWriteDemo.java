package com.scl.thread.concurrent.three;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description 读写锁分析
 *
 **********************************/
public class ReadWriteDemo {
    private  int readingReaders = 0;
    private  int waitingReaders = 0;
    private  int writingWriters = 0;
    private  int waitingWriters = 0;
    private  boolean preferWriter = true;

    ReadWriteDemo() {
        this(true);
    }

    ReadWriteDemo(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }


    public synchronized void readLock() throws InterruptedException {
        // 等待读人数+1
        this.waitingReaders++;
        try {
            // 正在写>0 或者 等待写>0
            while (this.writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
                this.wait();
            }
            this.readingReaders++;
        } finally {
            this.waitingReaders--;
        }
    }

    public synchronized void readUnLock() {
        this.readingReaders--;
        this.notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        try {
            this.waitingWriters++;
            while (readingReaders > 0 || this.writingWriters > 0) {
                this.wait();
            }
            this.writingWriters++;
        } finally {

            this.waitingWriters--;

        }

    }

    public synchronized void writeUnLock() {
        this.writingWriters--;
        this.notifyAll();
    }
}
