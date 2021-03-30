package com.ljj.malllearning.concurrent;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author ljj
 * @date 2021/3/5
 */
public class ScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);
        scheduledThreadPoolExecutor.execute(()->{
            System.out.println("ScheduledThreadPoolExecutor 执行任务");
        });




    }
}
