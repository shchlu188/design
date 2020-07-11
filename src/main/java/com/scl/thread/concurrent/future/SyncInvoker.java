package com.scl.thread.concurrent.future;

import java.util.concurrent.TimeUnit;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 *          Future ----->代表未来的凭据
 *          FutureTask ------>将调用逻辑进行隔离
 *          FutureService ---------->桥接Future和FutureTask
 **********************************/
public class SyncInvoker {
    public static void main(String[] args) throws InterruptedException {
//        String res = get();
//        System.out.println(res);
        FutureService service = new DefaultFutureService();
        Future<String> submit = service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISHED";
        },System.out::println);
//        System.out.println(submit.get());
        System.out.println("===================");
        System.out.println("do something.............");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("good future");
    }

    public static String get(){
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "FINISHED";
    }
}
