package com.scl.design.proxy.three;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class InvocationHandlerDemo {

    public static void main(String[] args) {
        IMsg msg = new MsgImpl();
        ServerProxy proxy = new ServerProxy(msg);
        IMsg bind = (IMsg) proxy.bind(msg);
        bind.echo("good");

    }
 /*   interface InvocationHandler {
        *//**
         *
         * @param proxy 描述代理类对象的实例，有动态代理类自行完成
         * @param method 要代理的方法
         * @param args 方法的参数
         * @return  方法的返回值
         * @throws Throwable
         *//*
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable;
    }*/
}
//核心业务接口
interface IMsg{
    String echo(String msg);
}
class MsgImpl implements  IMsg{
    @Override
    public String echo(String msg) {
        return "【echo】 "+msg;
    }
}

class ServerProxy implements InvocationHandler{
    private Object target;
    ServerProxy(Object target){
        this.target =target;
    }

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = null;
        if (connect()){
            returnValue= method.invoke(target,args);
            close();
        }
        return returnValue;
    }

    public Object bind(Object target){
        this.target =target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public boolean connect(){
        System.out.println("【代理业务】:\t"+"连接远程服务器，建立通信连接的通道");
        return true;
    }

    public void close(){
        System.out.println("【代理业务】:\t"+"关闭连接");
    }

}