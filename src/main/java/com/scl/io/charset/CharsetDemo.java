package com.scl.io.charset;

import com.scl.io.stream.FilePaths;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/4
 * @Description
 **********************************/
public class CharsetDemo {
    public static void main(String[] args) throws Exception {
        System.getProperties().list(System.out);
        File file = FilePaths.FILE;
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(new File("test.txt"));

        int b = 0;
        while ((b=fis.read())!=-1){
            fos.write((byte)b);
        }
        fis.close();
        fos.close();

    }
}
