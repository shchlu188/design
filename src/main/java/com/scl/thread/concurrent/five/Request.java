package com.scl.thread.concurrent.five;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class Request {
    private final String msg;

    Request(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
