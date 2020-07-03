package com.scl.io.file;


import java.io.*;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/3
 * @Description
 **********************************/
public class FileCopyDemo01 {
    static class FileCopyUtils{
        private File srcPath;
        private File  targetPath;
        /**
         *
         * @param srcPath 源文件路径
         * @param targetPath 目标文件路径
         */
        public FileCopyUtils(String srcPath,String targetPath){
            this.srcPath =new File(srcPath);
            this.targetPath =new File(targetPath);

            if (!this.targetPath.exists()){
                boolean b =false;
                try {
                    b = this.targetPath.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("目标文件创建成功:"+b);
                }
            }

        }

        public long copy() throws IOException{
            InputStream is = null;
            OutputStream os = null;
            long start = System.currentTimeMillis();
            System.out.println("【COPY FILE START】:"+ start);
            try{
                is = new FileInputStream(srcPath);
                os = new FileOutputStream(targetPath,true);
                byte[] buf = new byte[1024];
                int len = -1;
                while ((len=is.read(buf))!=-1){
                    os.write(buf,0,len);
                }

            }finally {
                assert is!=null;
                is.close();
                assert os!=null;
                os.close();

            }
            long end = System.currentTimeMillis();
            System.out.println("【COPY FILE END】:"+ end);

            return end-start;
        }
        public long copyJdk9() throws IOException{
            InputStream is = null;
            OutputStream os = null;
            long start = System.currentTimeMillis();
            System.out.println("【COPY FILE START】:"+ start);
            try{
                is = new FileInputStream(srcPath);
                os = new FileOutputStream(targetPath,true);
                is.transferTo(os);

            }finally {
                assert is!=null;
                is.close();
                assert os!=null;
                os.close();

            }

            long end = System.currentTimeMillis();
            System.out.println("【COPY FILE END】:"+ end);

            return end-start;
        }

    }
}
