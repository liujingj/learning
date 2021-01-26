package com.ljj.malllearning.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author ljj
 * @date 2021/1/15
 */
public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        //有个数限制的共享锁 一共两个锁 两个以上的线程来获取锁时 多余的被放到等待队列
        Semaphore semaphore = new Semaphore(2);
        //获取信号量许可 有可用的许可时 线程可以获取到 否则线程等待 直到有可用的许可为止

        //20分钟后释放锁
        new Thread(() -> {
            try {
                semaphore.acquire();
                Thread.sleep(1000 * 60 * 12);
                semaphore.release();
            } catch (InterruptedException e) {
            }
        }).start();

        //30分钟后释放锁
        new Thread(() -> {
            try {
                semaphore.acquire();
                Thread.sleep(1000 * 60 * 17);
                semaphore.release();
            } catch (InterruptedException e) {
            }
        }).start();

        //获取不到锁 等待有锁释放才能获取到
        new Thread(() -> {
            try {
                semaphore.acquire();
                semaphore.release();
            } catch (InterruptedException e) {
            }
        }).start();

        //获取不到锁
        new Thread(() -> {
            try {
                Thread.sleep(1000 * 60 * 2);
                semaphore.acquire();
                semaphore.release();
            } catch (InterruptedException e) {
            }
        }).start();

        //获取不到锁
        new Thread(() -> {
            try {
                Thread.sleep(1000 * 60 * 7);
                semaphore.acquire();
                semaphore.release();
            } catch (InterruptedException e) {
            }
        }).start();

    }
}
