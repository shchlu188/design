package com.scl.thread.concurrent.local;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/7
 * @Description
 **********************************/
public class ExecutionTask implements Runnable{
    private QueryDBAction action  = new QueryDBAction();

    private QueryFromHttpAction httpAction = new QueryFromHttpAction();
    @Override
    public void run() {
        final  Context context = new Context();
        action.execute(context);
        System.out.println(Thread.currentThread()+" >>>>QueryDBAction is successful");
        httpAction.execute(context);
        System.out.println(Thread.currentThread()+" >>>>QueryFromHttpAction is successful");
        System.out.println("The name is "+context.getName()+"and cardId is "+context.getCardId());

    }
}
