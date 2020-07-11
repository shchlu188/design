package com.scl.io.stream;

import java.io.*;
import java.util.Arrays;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/4
 * @Description
 **********************************/
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(args));
        CopyUtils copyUtils = new CopyUtils(new File(args[0]),new File(args[1]));

        copyUtils.copy();
    }
}

interface ICopy{
    public void copy() throws IOException;
}
class CopyUtils implements ICopy{
    private File srcFile;
    private File targetFile;
    public CopyUtils(File srcFile, File targetFile) {
        this.srcFile = srcFile;

        this.targetFile = targetFile;
    }

    @Override
    public void copy() throws IOException {
        long start = System.currentTimeMillis();
        if (!this.targetFile.exists()){
            if (this.targetFile.isDirectory()){
                this.targetFile.mkdirs();
            }else {
                this.targetFile.getParentFile().mkdirs();
            }
            this.copyHandle(this.srcFile);

        }

    }

    private void copyHandle(File file) {
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File tmp : files) {
                this.copyHandle(tmp);
            }
        }else {
            if (file.isFile()){
                try {
                    this.copyFile(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void copyFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos =null;
        if (this.srcFile.isDirectory()){
            String outFileName = file.getPath().replace(this.srcFile.getPath(),"");
            System.out.println(outFileName);
            File outFile = new File(this.targetFile, outFileName);
            if (!outFile.exists()){
                outFile.getParentFile().mkdirs();
            }
            fos = new FileOutputStream(outFile);


        }else {
            fos = new FileOutputStream(this.targetFile);
        }
        fis.transferTo(fos);

        fis.close();
        fos.close();
    }
}
