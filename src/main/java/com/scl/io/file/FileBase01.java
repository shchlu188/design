package com.scl.io.file;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/2
 * @Description
 **********************************/
public class FileBase01 {
    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "file" + File.separator + "a.txt");
//        System.out.println(file); // a.txt
        Optional.of(!file.getParentFile().exists()).ifPresent(b->{
            if (b) {
                System.out.println("目录不存在创建:"+file.mkdirs());
            }
        });
        // 判断文件是否存在
        Optional.of(file.exists()).ifPresent(b -> {
            if (b) {
                System.out.println("文件存在执行删除操作:" + file.delete());
            } else {
                try {

                    System.out.println("文件不存在执行创建操作:" + file.createNewFile());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
