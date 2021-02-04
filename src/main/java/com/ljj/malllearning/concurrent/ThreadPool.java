package com.ljj.malllearning.concurrent;

/**
 * @author ljj
 * @date 2021/2/2
 */
public interface ThreadPool<T extends Runnable> {
    /**
     * 执行一个任务 该任务必须实现runnable接口
     *
     * @param runnable
     */
    void execute(Runnable runnable);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 增加工作者线程
     *
     * @param num
     */
    void addThread(int num);

    /**
     * 减少工作者线程
     *
     * @param num
     */
    void removeThread(int num);

}
