package com.ljj.malllearning.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.util.CollectionUtils;

/**
 * @author ljj
 * @date 2021/2/2
 */
public class DefaultThreadPool<T extends Runnable> implements ThreadPool<Runnable> {
    /**
     * 线程池最大限制数
     */
    private static final int MAX_COUNT = 10;
    /**
     * 默认线程池数量
     */
    private static final int DEFAULT_COUNT = 5;
    /**
     * 线程池最小限制
     */
    private static final int MIN_COUNT = 1;

    /**
     * 任务列表
     */
    private static LinkedList<Runnable> taskList = new LinkedList<>();

    /**
     * 线程池
     */
    private List<ThreadWork> threadPoolList = Collections.synchronizedList(new ArrayList<>());
    /**
     * 线程池中线程数量
     */
    private int threadCount = DEFAULT_COUNT;

    public DefaultThreadPool() {
        initThreadPool(DEFAULT_COUNT);
    }

    private void initThreadPool(int count) {
        if (count <= 0) {
            return;
        }
        for (int i = 0; i < count; i++) {
            createThread();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (taskList) {
            taskList.addLast(runnable);
            //唤醒因拿不到任务而wait的线程
            taskList.notify();
        }
    }

    @Override
    public void shutdown() {
        //isWork 状态都修改为false
        for (ThreadWork thread : threadPoolList) {
            thread.isWork = false;
        }
    }

    @Override
    public void addThread(int num) {
        synchronized (taskList) {
            if (threadCount + num > MAX_COUNT) {
                num = MAX_COUNT - threadCount;
            }
            initThreadPool(num);
            threadCount = MAX_COUNT;
        }
    }

    @Override
    public void removeThread(int num) {
        synchronized (taskList) {
            if (threadCount - num < MIN_COUNT) {
                num = threadCount - MIN_COUNT;
            }
            for (int i = 0; i < num; i++) {
                ThreadWork thread;
                if ((thread = threadPoolList.remove(i)) != null) {
                    thread.isWork = false;

                }
            }
        }

    }

    private void createThread() {
        ThreadWork threadWork = new ThreadWork();
        Thread thread = new Thread(threadWork);
        threadPoolList.add(threadWork);
        thread.start();
        System.out.println("创建线程，threadName=" + thread.getName());
    }

    public static class ThreadWork implements Runnable {
        private volatile boolean isWork = true;

        @Override
        public void run() {
            while (isWork) {
                synchronized (taskList) {
                    while (CollectionUtils.isEmpty(taskList)) {
                        try {
                            System.out.println("队列没有任务，线程进行等待，threadName=" + Thread.currentThread().getName());
                            taskList.wait();
                        } catch (InterruptedException e) { }
                    }
                    Runnable task = taskList.removeFirst();
                    System.out.println("线程执行任务，threadName=" + Thread.currentThread().getName());
                    task.run();
                }
            }
            System.out.println("线程终止，threadName=" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DefaultThreadPool defaultThreadPool = new DefaultThreadPool();
        System.out.println("1  -----------");
        for (int i = 0; i < 5; i++) {
            defaultThreadPool.execute(() -> {
                System.out.println("任务被执行");
            });
            Thread.sleep(1000);
        }
        Thread.sleep(1000);
        System.out.println("2  -----------");

        defaultThreadPool.createThread();
        Thread.sleep(1000);
        System.out.println("3  -----------");

        defaultThreadPool.removeThread(3);
        Thread.sleep(1000);
        for (int i = 0; i < 3; i++) {
            defaultThreadPool.execute(() -> {
                System.out.println("任务被执行");
            });
            Thread.sleep(1000);
        }
        System.out.println("4  -----------");
        defaultThreadPool.shutdown();
        Thread.sleep(1000);
        for (int i = 0; i < 3; i++) {
            defaultThreadPool.execute(() -> {
                System.out.println("任务被执行");
            });
            Thread.sleep(1000);
        }
    }
}
