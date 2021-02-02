package com.ljj.malllearning.concurrent;

/**
 * @author ljj
 * @date 2021/1/14
 */
public class ThreadTest {

    public static synchronized void testThread() {
        System.out.println("获得锁的线程name=" + Thread.currentThread().getName() + "线程id=" + Thread.currentThread().getId());
    }

    private static final int count = 10000000;

    public static void main(String[] args) throws InterruptedException {
        //Thread thread1 = new Thread(() -> {
        //    while (true) {
        //        System.out.println("线程进行工作");
        //    }
        //});
        //thread1.start();
        //Thread.sleep(5);
        //thread1.suspend();
        //// TODO: 2021/1/27 将thread1 suspend后，主线程被阻塞了，下面的代码执行不到
        //System.out.println("------主线程将thread1暂停");
        //Thread.sleep(5);
        //System.out.println("------主线程将thread1唤醒");
        //thread1.resume();
        //Thread.sleep(5);
        //thread1.stop();
        //System.out.println("------主线程将thread1停止");

        //Thread thread1 = new Thread(() -> {
        //    try {
        //        Thread.sleep(1000 * 60 * 60);
        //    } catch (InterruptedException e) {
        //        System.out.println("thread1被打断");
        //    }
        //});
        //Thread thread2 = new Thread(() -> {
        //    while (true) {
        //
        //    }
        //});
        //thread1.start();
        //thread2.start();
        //
        //Thread.sleep(1000 * 5);
        //
        //thread1.interrupt();
        //thread2.interrupt();
        //
        //System.out.println("thread1 线程是否被打断" + thread1.isInterrupted());
        //System.out.println("thread2 线程是否被打断" + thread2.isInterrupted());

        //Thread.sleep(1000 * 60 * 5);
        //查看java程序包含哪些线程
        //java线程管理bean
        //ThreadMXBean threadMXBean=ManagementFactory.getThreadMXBean();
        //dump所有线程堆栈信息
        //ThreadInfo[] threadInfos=threadMXBean.dumpAllThreads(true,true);
        //ThreadInfo[] threadInfos1=threadMXBean.dumpAllThreads(false,false);
        //System.out.println(Arrays.toString(threadInfos));
        //System.out.println("===========");
        //System.out.println(Arrays.toString(threadInfos1));

        //Executor executor = Executors.newFixedThreadPool(2);
        //Executor executor1 = Executors.newFixedThreadPool(2);
        //for(int i=0;i<20;i++){
        //    executor.execute(() -> testThread());
        //    executor1.execute(() -> testThread());
        //}

        //        Thread.sleep(1000 * 60 * 60);

        //        concurrent();
        //        serial();
    }

    private static void concurrent() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread thread = new Thread(() -> test());
        thread.start();
        test();
        thread.join();
        System.out.println("concurrent times=" + (System.currentTimeMillis() - begin));
    }

    private static void serial() {
        long begin = System.currentTimeMillis();
        test();
        test();
        System.out.println("serial times=" + (System.currentTimeMillis() - begin));
    }

    private static void test() {
        int a = 0;
        for (int i = 0; i < count; i++) {
            a++;
        }
    }
}
