package com.scl.thread.concurrent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/9
 * @Description
 **********************************/
public class BalkingDemo {
    static class BalkingData{
        private final String fileName;
        private String content;
        private  boolean changed;
        private final Thread currentThread;

        public BalkingData(String firstName, String content) {
            this.fileName = firstName;
            this.content = content;
            this.changed = true;
            this.currentThread = Thread.currentThread();
        }

        public synchronized void change(String newContent){
            this.content = newContent;
            this.changed =false;
        }

        public synchronized void save(){
            if(!changed){
                return;
            }
            doSave();
            this.changed = false;
        }
        private void doSave(){
            System.out.println(currentThread.getName()+"[CALL <<DO>> SAVE]---->CONTENT <<IS>> CHANGED");
            try {
                FileWriter fileWriter = new FileWriter(new File(fileName), true);
                System.out.printf("【%s】>>>write data",currentThread.getName());
                fileWriter.write(content);
                System.out.printf("【%s】>>>write data finished",currentThread.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }











    public static void main(String[] args) {
        BalkingData balkingData = new BalkingData("a.txt","测试模式");


    }

}
