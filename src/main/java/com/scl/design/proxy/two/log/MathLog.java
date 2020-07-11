package com.scl.design.proxy.two.log;

import com.scl.design.proxy.two.anno.*;

@Aspect
public class MathLog {
    @Before
    public void preLog(){
        System.out.println("exec method before...........");
    }
    @After
    public void afterLog(){
        System.out.println("exec method after...........");
    }
    @AfterReturning
    public void returnLog(){
        System.out.println("exec method return...........");
    }

    @AfterThrowing
    public void exceptionLog(){
        System.out.println("exec method return...........");
    }

}
