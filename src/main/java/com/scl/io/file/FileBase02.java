package com.scl.io.file;

import java.io.File;
import java.util.Optional;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/2
 * @Description
 **********************************/
public class FileBase02 {
    private static File parentFile = new File("E:" + File.separator + "file" + File.separator+"a.txt");

    static {
        // 耗时操作就进行一次就好
        if (!parentFile.getParentFile().exists()){
            System.out.println("创建目录：");
            parentFile.getParentFile().mkdirs();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                File file = new File("E:" + File.separator + "file" + File.separator +Thread.currentThread().getName());
                // 判断文件是否存在
                if (file.exists()) {
                    System.out.println("文件存在执行删除操作:" + file.delete());
                } else {
                    try {

                        System.out.println("文件不存在执行创建操作:" + file.createNewFile());
                    } catch (Exception e) {
                    }
                }
            }, "Thread-"+i).start();
        }


    }
}
