package com.scl.thread.concurrent.local.improve;

import com.scl.thread.concurrent.local.Context;
import com.scl.thread.concurrent.local.QueryDBAction;
import com.scl.thread.concurrent.local.QueryFromHttpAction;
import org.checkerframework.checker.units.qual.A;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/7
 * @Description
 **********************************/
public class ExecutionThreadLocalTask implements Runnable{
    private QueryThreadLocalDBAction action  = new QueryThreadLocalDBAction();

    private QueryThreadLocalFromHttpAction httpAction = new QueryThreadLocalFromHttpAction();
    @Override
    public void run() {
        action.execute();
        System.out.println(Thread.currentThread()+" >>>>QueryDBAction is successful");
        httpAction.execute();
        Context context = ActionContext.getInstance().getContext();
        System.out.println(Thread.currentThread()+" >>>>QueryFromHttpAction is successful");
        System.out.println("The name is "+context.getName()+"and cardId is "+context.getCardId());

    }
}
