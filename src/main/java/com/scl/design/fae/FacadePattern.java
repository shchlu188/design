package com.scl.design.fae;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/6
 * @Description 外观模式
 **********************************/
public class FacadePattern {

}

class SubFlow{
    boolean isTrue(){
        return true;
    }
}
class Subflow2{
    boolean isOk(){
        return true;
    }
}

class SubFlow3{
    boolean IsGoodMan(){return true;}
}


class Facade{
    SubFlow subFlow = new SubFlow();
    Subflow2 subflow2 =new Subflow2();
    SubFlow3 subFlow3 =  new SubFlow3();
    void prove(){
        subFlow.isTrue();
        subflow2.isOk();
        subFlow3.IsGoodMan();
    }
}
