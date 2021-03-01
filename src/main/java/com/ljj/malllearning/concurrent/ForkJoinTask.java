package com.ljj.malllearning.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author ljj
 * @date 2021/2/26
 */
public class ForkJoinTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 3;
    private int start;
    private int end;
    public ForkJoinTask(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        int sum = 0;
        //任务足够小就执行
        if (end - start <= THRESHOLD) {
            for (int i = start; i < end; i++) {
                sum += i;
            }
        } else {
            //任务不够小 就分割成两个子任务
            int middle = (start + end) / 2;
            ForkJoinTask leftTask = new ForkJoinTask(start, middle);
            ForkJoinTask rightTask = new ForkJoinTask(middle + 1, end);
            //每个子任务又会进入compute 看看当前子任务是否需要继续分割
            leftTask.fork();
            rightTask.fork();
            //阻塞当前线程并获取结果
            int left = leftTask.join();
            int right = rightTask.join();
            sum = left + right;
        }
        return sum;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool(3);
        ForkJoinTask task = new ForkJoinTask(1, 12);
        Future<Integer> future = pool.submit(task);
        System.out.println(future.get());
    }
}
