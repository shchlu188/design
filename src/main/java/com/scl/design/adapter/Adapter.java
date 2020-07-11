package com.scl.design.adapter;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/6
 * @Description
 **********************************/
public class Adapter extends Speaker implements Translater {

    @Override
    public String translate() {
        String speak = super.speak();
        // do something
        return speak;
    }
}
