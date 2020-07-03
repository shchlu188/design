package com.scl.io.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/3
 * @Description  public class FilterOutputStream extends OutputStream
 **********************************/
public class FileOutputStreamDemo01 {

    private static File file = new File("D:" + File.separator + "file" + File.separator + "a.txt");

    public static void main(String[] args) throws Exception {
        if (!file.getParentFile().exists()){
            boolean flag = file.getParentFile().mkdirs();
            System.out.println("创建目录成功:"+flag);
        }
        if (!file.exists()){
            System.out.println("创建文件成功:"+file.createNewFile());
        }
        OutputStream os = new FileOutputStream(file);

        os.write("shchlu188@163.com".getBytes());
    }

}
