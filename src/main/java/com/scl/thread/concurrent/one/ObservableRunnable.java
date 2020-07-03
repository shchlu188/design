package com.scl.thread.concurrent.one;

import java.util.List;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/4
 * @Description 主题
 **********************************/
public abstract class ObservableRunnable implements Runnable {
    final protected LifeCycleListener lifeCycleListener;

    public ObservableRunnable(final LifeCycleListener lifeCycleListener) {
        this.lifeCycleListener = lifeCycleListener;
    }

    protected void notifyChange(RunnableEvent event){
        lifeCycleListener.onEvent(event);

    }


    public enum RunnableState{
        RUNNING,ERROR,DONE;
    }

    public static class  RunnableEvent{
        private final RunnableState runnableState;
        private final Thread thread;
        private final Throwable cause;

        public Thread getThread() {
            return thread;
        }

        public Throwable getCause() {
            return cause;
        }

        public RunnableState getRunnableState() {
            return runnableState;
        }

        public RunnableEvent(RunnableState runnableState, Thread thread, Throwable cause) {
            this.runnableState = runnableState;
            this.thread = thread;
            this.cause = cause;
        }
    }

}
