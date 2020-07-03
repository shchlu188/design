package com.scl.io.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/3
 * @Description 统一文件后缀长度
 **********************************/
public class UnionFileSuffixName {
    private static   File dir;

    static {
        dir = new File("E:" + File.separator + "file" + File.separatorChar);
        if (!dir.exists()){
            // 耗时操作就进行一次就好
            System.out.println("目录不存在创建");
            boolean flag = dir.mkdirs();
            System.out.println("目录创建成功："+flag);

        }


    }


    public static void main(String[] args) throws IOException {
        UnionFileSuffixName unionFileSuffixName = new UnionFileSuffixName();
        boolean b;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        for (int i = 0; i < 40; i++) {
            File file = new File(dir,"scl-"+sdf.format(new Date())+"-"+i+".log");
            b = file.createNewFile();
        }
    }
}
