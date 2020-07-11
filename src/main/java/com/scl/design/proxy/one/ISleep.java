package com.scl.design.proxy.one;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description 睡觉
 **********************************/
public interface ISleep {
    String make();
}

class SleepReal implements ISleep{
    @Override
    public String make() {
        System.out.println("{真实业务}=====>[XXXXX]");


        return "good";

    }
}
