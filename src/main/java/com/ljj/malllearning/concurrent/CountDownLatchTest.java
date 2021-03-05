package com.ljj.malllearning.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author ljj
 * @date 2021/1/15
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        //state=2
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            System.out.println("first");
            //countDown state-1
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
            }
            System.out.println("second");
            countDownLatch.countDown();
        }).start();

        System.out.println("await");

        //阻塞当前线程直到state变为0
        countDownLatch.await();
        System.out.println("done");
    }
}

