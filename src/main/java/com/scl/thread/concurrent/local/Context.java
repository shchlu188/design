package com.scl.thread.concurrent.local;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/7
 * @Description
 **********************************/
public class Context {
    private String name;
    private String cardId;
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCardId(String cardId) {
        this.cardId =cardId;
    }

    public String getCardId() {
        return cardId;
    }
}
