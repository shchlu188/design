package com.scl.design.proxy.three;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.EmptyStackException;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class CglibProxyDemo {
    public static void main(String[] args) {
            MsgImpl msg = new MsgImpl();
            ServerCglibProxy proxy = new ServerCglibProxy(msg);
        MsgImpl instance = (MsgImpl) proxy.getProxyInstance();
//        instance.echo("cglib proxy");
        instance.ico();


    }

    static class MsgImpl {
        public String echo(String msg) {
            System.out.println("【核心业务逻辑】======>回显信息");
            return "【echo】 "+msg;
        }

        public void ico(){
            System.out.println("good====>");
        }

    }

    static class ServerCglibProxy implements MethodInterceptor{
        private Object target;
        public ServerCglibProxy(Object target){
            this.target = target;
        }

        public Object getProxyInstance(){
            Enhancer enhancer = new Enhancer();
            enhancer.setCallback(this);
            enhancer.setSuperclass(target.getClass());

            return enhancer.create();

        }

        /**
         *
         * @param proxyObject 代理对象
         * @param method 方法接口
         * @param args 参数
         * @param methodProxy 方法代理接口
         * @return
         * @throws Throwable
         */
        @Override
        public Object intercept(Object proxyObject, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            Object returnValue=null;
            if (methodProxy.getSignature().getName().equalsIgnoreCase("echo")) {
                if (connect()) {
                    returnValue = method.invoke(target, args);
                    close();
                }
            }else {
                returnValue = method.invoke(target,args);
            }
            return returnValue ;
        }
        public boolean connect(){
            System.out.println("【代理业务】:\t"+"连接远程服务器，建立通信连接的通道");
            return true;
        }

        public void close(){
            System.out.println("【代理业务】:\t"+"关闭连接");
        }

    }
}
