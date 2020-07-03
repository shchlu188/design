package com.scl.io.stream;

import java.io.IOException;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/3
 * @Description
 **********************************/
public class WriterDemo {
    public static void main(String[] args) {

    }
    public interface Appendable{
        java.lang.Appendable append(CharSequence csq, int start, int end) throws IOException;
        java.lang.Appendable append(char c) throws IOException;
        java.lang.Appendable append(CharSequence csq) throws IOException;
    }
}
