package com.scl.io.stream;

import java.io.FileOutputStream;
import java.io.FileWriter;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/3
 * @Description
 **********************************/
public class CharAndByteDiff {
    public static void main(String[] args) throws Exception{
        // 字节输出流
      /*  FileOutputStream fos = new FileOutputStream(FilePaths.FILE);
        fos.write("www.baidu.com haha".getBytes());*/
        // 字符输出流
        FileWriter fw = new FileWriter(FilePaths.FILE);
        fw.write("www.baidu.com haha");
        fw.flush();
    }
}
