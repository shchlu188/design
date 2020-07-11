package com.scl.thread.concurrent.local;

import com.google.errorprone.annotations.Var;

import java.awt.font.TextHitInfo;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/7
 * @Description
 **********************************/
public class QueryFromHttpAction {
    public void execute(Context context){
        String name = context.getName();
        String cardId = getCardId(name);
        context.setCardId(cardId);
    }

    private String getCardId(String name){
        try {
            Thread.sleep(1_1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "123743962947104701"+Thread.currentThread();
    }
}
