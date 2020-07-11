package com.scl.io.stream;

import java.io.FileDescriptor;
import java.io.RandomAccessFile;
import java.util.Locale;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/4
 * @Description
 *  public class RandomAccessFile implements
 *                                              DataOutput,
 *                                              DataInput,
 *                                              Closeable
 *                public interface DataOutput
 *                public interface DataOutput
 *                public interface Closeable extends AutoCloseable
 *****************************************************
 *              public RandomAccessFile(String name, String mode)
 *              public RandomAccessFile(File file, String mode)
 *              private RandomAccessFile(File file, String mode, boolean openAndDelete)
 **********************************/
public class RandomAccessStreamDemo {
    public static void main(String[] args) throws Exception{
        RandomAccessFile raf = new RandomAccessFile("a.txt", "rw");

    }
}
