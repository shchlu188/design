package com.scl.thread.syn;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/1
 * @Description
 **********************************/
public class CaptureService {
    private static final LinkedList<Control> CONTROLS = new LinkedList<>();

    private static final int DEFAULT_SIZE =5;
    public static void main(String[] args) {
        String[] arr = new String[10];
        final List<Thread> worker = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            arr[i] = "M"+(i+1);
        }
        Arrays.stream(arr)
                .map(CaptureService::createCaptureThread)
                .forEach(t->{
                    t.start();
                    worker.add(t);
                });
        worker.forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Optional.of("all of Capture worker finished").ifPresent(System.out::println);
    }

    public static Thread createCaptureThread(String name){
        return  new Thread(()->{
            Optional.of("The worker [ "+Thread.currentThread().getName()+" ] begin capture data").ifPresent(System.out::println);
            synchronized (CONTROLS){
                while (CONTROLS.size()>DEFAULT_SIZE){
                    try {
                        CONTROLS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                CONTROLS.addLast(new Control());
            }
            Optional.of("The worker ["+Thread.currentThread().getName()+"] is working").ifPresent(System.out::println);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (CONTROLS){
                Optional.of("the worker ["+Thread.currentThread().getName()+"] end Capture data").ifPresent(System.out::println);
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }
        },name);
    }

    private  static class Control{

    }
}
