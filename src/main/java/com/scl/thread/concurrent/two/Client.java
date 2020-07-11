package com.scl.thread.concurrent.two;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class Client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User u1 = new User("bus", "bj", gate);
        User u2 = new User("scl", "nj", gate);
        User u3 = new User("GZ", "GD", gate);

//        u1.start();
        u2.start();
        u3.start();
    }
}
