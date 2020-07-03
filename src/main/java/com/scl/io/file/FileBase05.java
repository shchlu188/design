package com.scl.io.file;

import java.io.File;
import java.util.Arrays;

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
public class FileBase05 {
    private static String fileName = "E:"+File.separator+"scl-doc"+File.separator;
    public static void main(String[] args) {

        File file = new File(fileName);
     if (file.isDirectory()){
         System.out.printf("list() method exec:\n");
         // 计算机
         Arrays.stream(file.list()).forEach(System.out::println);
         System.out.printf("list() method exec finshed:\n");
         // E:\scl-doc\计算机
         Arrays.stream(file.listFiles()).forEach(System.out::println);
     }
    }

}
