package com.scl.thread.pool;

import java.io.EOFException;
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
 *
 **********************************/
public class ThreadPoolVerion1 {

    private final int size;

    private final static int DEFAULT_SIZE = 10;
    // 任务队列
    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    private volatile static int seq = 0;

    private final static String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";

    private final static ThreadGroup GROUP = new ThreadGroup("POOL_GROUP");

    private final static List<WorkTask> THREAD_QUEUE = new ArrayList<>();

    public ThreadPoolVerion1() {
        this(DEFAULT_SIZE);
    }

    public ThreadPoolVerion1(int size) {

        this.size = size;
        init();
    }

    public void submit(Runnable runnable){
        synchronized (TASK_QUEUE){
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }


    private void init() {
        for (int i = 0; i < size; i++) {
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

    private static class WorkTask extends Thread {
        // 设置默认状态
        private volatile TaskState taskState = TaskState.FREE;

        public TaskState getTaskState() {
            return taskState;
        }

        public WorkTask(ThreadGroup group, String name) {
            super(group, name);
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

}
