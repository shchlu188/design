package com.scl.io.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 *
 *      获取文件权限
 **********************************/
public class FileBase04 {
    private static String fileName = "E:"+File.separator+"scl-doc"+File.separator+"test.zip";
    public static void main(String[] args) {

        File file = new File(fileName);
        if (file.exists()){
            System.out.printf("【文件的权限】可读:%s 可写:%s,可执行:%s\n",file.canRead(),file.canWrite(),file.canExecute());
            System.out.printf("【文件的绝对路径】: %s\n",file.getAbsolutePath());
            System.out.printf("【文件的父路径】%s\n",file.getParentFile());
            System.out.printf("【文件的目录】: %s\n",file.getParent());
            System.out.printf("【文件名称】： %s\n",file.getName());
            System.out.printf("【文件类型】: 目录：%s,文件：%s",file.isDirectory(),file.isFile());
        }
    }

}
