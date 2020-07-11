package com.scl.thread.concurrent.local.improve;

import com.scl.thread.concurrent.local.Context;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/7
 * @Description
 **********************************/
public class QueryThreadLocalFromHttpAction {
    public void execute(){
        String name = ActionContext.getInstance().getContext().getName();
        String cardId = getCardId(name);
        ActionContext.getInstance().getContext().setCardId(cardId);
    }

    private String getCardId(String name){
        try {
            Thread.sleep(1_1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name+ "》》》 123743962947104701》》》"+Thread.currentThread();
    }
}
