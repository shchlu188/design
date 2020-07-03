package com.scl.io.stream;

import java.awt.image.Kernel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/3
 * @Description
 *
 * ***********************
 *      public int available() throws IOException 获取全部的可用字节
 *      public abstract int read() throws IOException
 *                  <li>
 *                      <ul>从输入源中读取下一个字节，并且以<code>int</code>返回，范围在0-255;返回-1表示结束</ul>
 *                      <ul>读取的字节以整型返回；</ul>
 *                      <ul>该方法为阻塞方法，方法结束的条件为：
 *                          <li>input data is available</li>
 *                          <li>end of the stream is detected</li>
 *                          <li>an exception is thrown</li>
 *                      </ul>
 *
 *                  </li>
 *      public int read(byte b[]) throws IOException
 *      public int read(byte b[], int off, int len) throws IOException
 *
 **********************jdk9****************************
 *      public byte[] readAllBytes() throws IOException Reads all remaining bytes from the input stream。
 *      public long transferTo(OutputStream out) throws IOException 转换流
 **********************************/
public class InputStreamBase01 {
    public static void main(String[] args) throws Exception {
        File file  = FilePaths.FILE;
        InputStream is = new FileInputStream(file);
        byte[] buf = new byte[1024];
        int len=-1;
        while ((len=is.read(buf))!=-1){

            System.out.println(new String(buf,0, len));
        }

    }
}
