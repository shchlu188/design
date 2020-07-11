package com.scl.thread.concurrent.two;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class User extends Thread {
    private final String userName;
    private final String userAddr;
    private final Gate gate;

    public User(String userName, String userAddr, Gate gate) {
        this.userName = userName;
        this.userAddr = userAddr;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(userName+"*********BEGIN");

        while (true){
            gate.pass(userName,userAddr);
        }
    }
}
