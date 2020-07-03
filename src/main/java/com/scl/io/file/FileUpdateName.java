package com.scl.io.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.stream.IntStream;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/3
 * @Description 文件更名
 **********************************/
public class FileUpdateName {
    public static boolean updateName(String srcName, String upDateName) {
        File srcFile = new File(srcName);
        File updateFile = new File(srcName);

        return srcFile.renameTo(updateFile);
    }

    public static  boolean upDateName(File src,File target){
        return src.renameTo(target);
    }

    private final static File dir = new File("d:"+ File.separator+"logs"+ File.separator);

    static {
        if (!dir.exists()){
            dir.mkdirs();
        }

    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        IntStream.range(0,40)
                .forEach(idx-> {
                    try {
                        new File(dir,"scl-"+sdf.format(new Date())+"-"+idx+".log").createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
