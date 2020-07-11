package com.scl.thread.concurrent.local;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/7
 * @Description
 **********************************/
public class QueryDBAction {
    public void execute(Context context){
        try {
            Thread.sleep(1_000);
            String name = "Alex"+Thread.currentThread()+">>>"+System.currentTimeMillis();
            context.setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
