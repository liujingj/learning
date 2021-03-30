package com.ljj.malllearning.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author ljj
 * @date 2021/1/15
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //int corePoolSize = 2;
        //int maximumPoolSize = 3;
        //long keepAliveTime = 5L;
        ////keepAliveTime的单位
        //TimeUnit unit = TimeUnit.MINUTES;
        //BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(2);
        //RejectedExecutionHandler handler = new AbortPolicy();
        //ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
        //    workQueue, handler);
        ////不带返回值
        //executor.execute(() -> {
        //    System.out.println("执行任务");
        //});
        ////带返回值
        //Future future = executor.submit(() -> {
        //    int a = 2;
        //    return a;
        //});
        //
        //executor.getActiveCount();
        //System.out.println(future.get());
        //executor.shutdownNow();

        //Executors.newFixedThreadPool(2);
        //Executors.newSingleThreadExecutor();
        //ExecutorService executorService = Executors.newCachedThreadPool();
        //executorService.execute(() -> {
        //    System.out.println("1");
        //});
        //
        //Thread.sleep(1000 * 20);
        //executorService.execute(() -> {
        //    System.out.println("2");
        //});


    }
}
