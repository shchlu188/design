package com.scl.design.proxy.one;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description 睡觉代理
 **********************************/
public class SleepProxy implements ISleep {
    private ISleep iSleep;

    SleepProxy(ISleep iSleep) {
        this.iSleep = iSleep;
    }

    @Override
    public String make() {

        // 真实业务
        String make = null;
        try {
            // 睡觉之前干点事
            note();
            give();
            make = iSleep.make();
        } catch (Exception e) {
            tired(e);
        } finally {
            // 睡觉之后干点事
            move();
        }

        return make;
    }

    private void tired(Exception e) {
        System.out.println("【代理业务】======>皇上圣体不适："+e);
    }

    private void give() {
        System.out.println("【代理业务】====>沐浴更衣");

    }

    private void note() {
        System.out.println("【代理业务】====>选妃子侍寝");
    }

    private void move() {
        System.out.println("【代理业务】====>送回寝宫");
    }


}
