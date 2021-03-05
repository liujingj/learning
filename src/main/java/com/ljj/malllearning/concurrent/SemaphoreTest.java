package com.ljj.malllearning.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 共享锁的实现
 *
 * @author ljj
 * @date 2021/1/15
 */
public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);

        new Thread(() -> {
            try {
                semaphore.acquire();
                Thread.sleep(1000*60);
                System.out.println("线程1获取到锁");
                semaphore.release();
            } catch (InterruptedException e) {
            }
        }).start();

        new Thread(() -> {
            try {
                semaphore.acquire();
                Thread.sleep(1000*60);
                System.out.println("线程2获取到锁");
                semaphore.release();
            } catch (InterruptedException e) {
            }
        }).start();

        //在等待队列中阻塞 线程1和线程2中释放一个锁 线程3才能获取到
        new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("线程3获取到锁");
                semaphore.release();
            } catch (InterruptedException e) {
            }
        }).start();
    }
}


