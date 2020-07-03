package com.scl.io.file;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Optional;

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
 *      获取文件的大小和修改日期
 **********************************/
public class FileBase03 {
    private static String fileName = "E:"+File.separator+"scl-doc"+File.separator+"test.zip";
    public static void main(String[] args) {

        File file = new File(fileName);
        if (file.exists()){
            System.out.printf("The file size is %5.2f M\n",(double)file.length()/1024/1024);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.printf("The file last modified is %d, date: %s ",file.lastModified(), sdf.format(new Date(file.lastModified())));
        }
    }

}
