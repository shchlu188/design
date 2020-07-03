package com.scl.thread.pool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/2
 * @Description 线程池
 *                  任务队列
 *                  拒绝策略（抛出异常、直接丢弃、阻塞、临时队列）
 *                  init 初始化线程数
 *                  active 活跃时线程数
 *                  max  最大线程数
 *
 *                 min>=active>=max
 **************************
 *          增加关闭线程池的方法
 **********************************/
public class ThreadPoolVerion3 {

    private final int poolSize;   // 线程池大小
    private final int queueSize; // 任务队列的大小
    private final RejectionStrategy rejectionStrategy; // 拒绝策略
    // 默认线程数
    private final static int DEFAULT_THREAD_SIZE = 10;
    // 默认任务数
    private final static int DEFAUT_TASK_SIZE = 2000;
    // 任务队列
    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    private volatile static int seq = 0;
    private volatile boolean distroy = false;

    private final static String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";

    private final static ThreadGroup GROUP = new ThreadGroup("POOL_GROUP");

    private final static List<WorkTask> THREAD_QUEUE = new ArrayList<>();
    // 默认拒绝策略
    private final static RejectionStrategy DEFAULT_REJECT_POLICY = new SimpleRejectionStrategy();

    public ThreadPoolVerion3() {
        this(DEFAULT_THREAD_SIZE);
    }

    public ThreadPoolVerion3(int threadSize, int taskSize, RejectionStrategy rejectionStrategy) {
        this.poolSize = threadSize;
        this.queueSize = taskSize;
        this.rejectionStrategy = rejectionStrategy;
        init();
    }

    public ThreadPoolVerion3(int threadSize, int taskSize) {
        this(threadSize, taskSize, DEFAULT_REJECT_POLICY);

    }

    public ThreadPoolVerion3(int threadSize) {
        this(threadSize, DEFAUT_TASK_SIZE);
    }

    /**
     * 注册任务
     *
     * @param runnable
     */
    public void submit(Runnable runnable) {
        if (distroy) {
            throw new RuntimeException("The thread Pool is already destroy and not allow submit task.");
        }

        synchronized (TASK_QUEUE) {
            if (TASK_QUEUE.size() > queueSize)
                rejectionStrategy.reject();
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    /**
     * 关闭线程池
     *
     * @throws InterruptedException
     */
    public void shutDown() throws InterruptedException {
        while (!TASK_QUEUE.isEmpty()) {
            Thread.sleep(50);
        }
        int initVal = THREAD_QUEUE.size();
        while (initVal > 0) {
            for (WorkTask task : THREAD_QUEUE) {
                if (task.getTaskState() == TaskState.BLOCKED) {
                    task.interrupt(); // 中断
                    task.close();
                    initVal--;
                } else {
                    Thread.sleep(10);
                }
            }
        }
        this.distroy = true;
        System.out.println("this thread pool disposed.");
    }

    public void destroy() {
        this.distroy = true;
    }

    /**
     * 初始化线程池
     */
    private void init() {
        for (int i = 0; i < poolSize; i++) {
            createWorkTask();
        }
    }

    private void createWorkTask(String name) {
        WorkTask worker = new WorkTask(GROUP, name);
        worker.start();
        THREAD_QUEUE.add(worker);
    }

    private void createWorkTask() {
        createWorkTask(THREAD_PREFIX + (seq++));
    }

    /**
     * 线程状态
     */
    private enum TaskState {
        FREE, RUNNING, BLOCKED, DEAD;
    }

    /**
     * 工作任务
     */
    private static class WorkTask extends Thread {
        // 设置默认状态
        private volatile TaskState taskState = TaskState.FREE;

        public TaskState getTaskState() {
            return taskState;
        }

        public WorkTask(ThreadGroup group, String name) {
            super(group, name);
        }

        // 将线程标记
        public void close() {
            this.taskState = TaskState.DEAD;
        }

        @Override
        public void run() {
            QURTER:
            while (this.taskState != TaskState.DEAD) {
                Runnable task;
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break QURTER;
                        }

                    }
                    task = TASK_QUEUE.removeFirst();

                }
                if (task != null) {
                    // 设置为运行状态
                    taskState = TaskState.RUNNING;
                    task.run();
                    // 设置为空闲
                    taskState = TaskState.FREE;
                }

            }
        }
    }

    public static class RejectionException extends RuntimeException {
        RejectionException(String message) {
            super(message);
        }
    }

    public interface RejectionStrategy {
        void reject() throws RejectionException;
    }

    static class SimpleRejectionStrategy implements RejectionStrategy {

        @Override
        public void reject() throws RejectionException {
            throw new RejectionException("reject the task...");
        }
    }

}
