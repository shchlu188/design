package com.scl.thread.concurrent.two;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class Gate {
    private int counter=0;
    private String name="NoBody";
    private String address = "NoWhere";

    public synchronized void pass(String name,String address){
        counter++;
        this.name =name;
        this.address=address;
        verify();
    }

    private void verify() {
        if (this.name.charAt(0)!=this.address.charAt(0)){
            System.out.println("***********Broken***********"+toString());
        }
    }

    @Override
    public String toString() {
        return "Gate{" +
                "counter=" + counter +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
