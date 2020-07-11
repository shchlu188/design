package com.scl.thread.concurrent.local.improve;

import com.scl.thread.concurrent.local.Context;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/7
 * @Description
 **********************************/
public class ActionContext {
    private static final ThreadLocal<Context> THREAD_LOCAL = new ThreadLocal<>(){
        @Override
        protected Context initialValue() {
            return new Context();
        }
    };

    private ActionContext(){}
    public static ActionContext getInstance(){
        return ContextHolderEnum.SINGLE.actionContext;
    }
    public  Context getContext(){
        return THREAD_LOCAL.get();
    }
   private enum ContextHolderEnum {
        SINGLE;
        private final ActionContext actionContext = new ActionContext();

    }

}
