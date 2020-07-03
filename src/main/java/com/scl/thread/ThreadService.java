package com.scl.thread;

/**
 * @author scl
 * @Date 2020/7/1
 * @Description
 */
public class ThreadService {
    private Thread executeThread;
    private boolean finished = false;

    public void execute(Runnable task) {
        executeThread = new Thread(() -> {
            Thread runner = new Thread(task);
            runner.setDaemon(true);
            runner.start();

            try {
                runner.join();
                finished = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });
        executeThread.start();
    }

    public void close(long mills) {
        long start = System.currentTimeMillis();
        while (!finished) {
            if ((System.currentTimeMillis() - start) > mills) {
                System.out.println("任务超时.........请重试");
                break;
            }
            try {
                executeThread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断");
                break;
            }

        }
        finished = false;

    }

    public static void main(String[] args) {
        ThreadService service = new ThreadService();
        long start = System.currentTimeMillis();
        service.execute(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.close(10000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);


    }
}
