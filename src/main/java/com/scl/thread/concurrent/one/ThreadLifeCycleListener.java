package com.scl.thread.concurrent.one;

import java.util.List;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/4
 * @Description
 **********************************/
public class ThreadLifeCycleListener implements LifeCycleListener {
    private final Object LOCK = new Object();

    public void concurrentQuery(List<String> ids) {
        if (null == ids || ids.isEmpty()) {
            return;
        }
        ids.forEach(id -> new Thread(new ObservableRunnable(this) {
            @Override
            public void run() {
                try {
                    notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
                    System.out.println("query for the id: " + id);
                    Thread.sleep(5_000);
                    notifyChange(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));

                } catch (Exception e) {
                    notifyChange(new RunnableEvent(RunnableState.ERROR,Thread.currentThread(),e));
                }

            }
        },id).start());
    }

    @Override
    public void onEvent(ObservableRunnable.RunnableEvent event) {
        synchronized (LOCK){
            System.out.println("the runnable 【"+Thread.currentThread().getName()+"】 data change and state is "+event.getRunnableState());
            if (event.getCause()!=null){
                System.out.println("the runnable 【"+Thread.currentThread().getName()+"】 process failed");

                event.getCause().printStackTrace();
            }
        }
    }
}
