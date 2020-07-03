package com.scl.design.strategy;

/**
 * @author scl
 * @Date 2020/7/1
 * @Description 赵云
 */
public class Person {
    private Stratagem stratagem;
    Person(Stratagem stratagem){
        this.stratagem =stratagem;
    }

    public void exec(){
        stratagem.exec();
    }
}
