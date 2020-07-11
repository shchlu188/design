package com.scl.thread.concurrent.local.improve;

import com.scl.thread.concurrent.local.Context;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/7
 * @Description
 **********************************/
public class QueryThreadLocalDBAction {
    public void execute(){
        try {
            Thread.sleep(1_000);
            String name = "Alex"+Thread.currentThread()+"  >>>  "+System.currentTimeMillis();
            ActionContext.getInstance().getContext().setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
