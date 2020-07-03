package com.scl.io.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/3
 * @Description 获取文件信息
 *      File​(String pathname)   Creates a new File instance by converting the given pathname string into an abstract pathname.
 *      ***********
 *      boolean	canExecute() 执行
 *      boolean	canRead() 可读
 *      boolean	canWrite() 可写
 *      ************
 *      File	getAbsoluteFile()
 *      String	getAbsolutePath()
 *      String	getName()
 *      String	getParent()
 *      ************
 *      boolean	isAbsolute()
 *      boolean	isDirectory()
 *      boolean	isFile()
 *      boolean	isHidden()
 *      *************
 *      long	lastModified() 最后依次修改日期
 *      long	length()
 *
 *
 *      *************
 *       add ops
 *          String[]	list()
 *          File[]	listFiles()
 *          String[]	list​(FilenameFilter filter)
 **********************************/
public class FileBase06 {
    private static String fileName = "E:" + File.separator + "scl-doc" + File.separator;

    public static void main(String[] args) throws InterruptedException {

        File file = new File(fileName);
        CountDownLatch cdl = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                info(file);
                cdl.countDown();
            }).start();
        }
        cdl.await();
        System.out.println("文件数: "+fileList.size());
        fileList.forEach(System.out::println);
    }

    private volatile static List<File> fileList = new ArrayList<>();

    public static void info(File file) {
        if (file.isDirectory()) {
            File[] list = file.listFiles(f -> f.isDirectory() || f.getName().endsWith(".txt"));
            assert list != null;
            Arrays.stream(list).forEach(FileBase06::info);
        } else {
            fileList.add(file);
        }
    }

}
