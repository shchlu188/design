package com.scl.io.stream;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/3
 * @Description
 **********************************/
public class TransferStreamDemo {
    public static void main(String[] args) throws Exception{
        OutputStream os = new FileOutputStream(FilePaths.FILE);

        OutputStreamWriter osw = new OutputStreamWriter(os);

        osw.write("com.scl.io.stream.CharAndByteDiff");

        osw.flush();
    }
}
