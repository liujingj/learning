package com.ljj.malllearning.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author ljj
 * @date 2021/1/15
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        //创建sync volatile 同步状态state=count 并发修改state的值 当state=0时执行doReleaseShared
        CountDownLatch countDownLatch = new CountDownLatch(2);
        //countDown 和 await不确定先后执行顺序
        //countDown releaseShared(AQS定义) 尝试释放 tryReleaseShared(CountDownLatch自己实现) 如果state=0 直接return 先把state-1 并cas修改state状态 如果此时state还是！=0，直接return 如果正好是最后一个执行完state=0，则 执行 doReleaseShared
        //doReleaseShared 死循环 AQS定义 head ！= tail 才会执行
        new Thread(() -> {
            System.out.println("first");
            countDownLatch.countDown();
        }).start();


        new Thread(() -> {
            try {
                Thread.sleep(1000 * 60 * 3);
            } catch (InterruptedException e) {
            }
            System.out.println("second");
            countDownLatch.countDown();
        }).start();

        System.out.println("await");

        // acquireSharedInterruptibly(AQS) tryAcquireShared(自己)如果state ！= 0执行 doAcquireSharedInterruptibly(AQS)
        // 共享node-Shard ，创建head tail 两个node，并且将二者关联 如果state=0 head=tail tail.pre=null  doReleaseShared->如果head==tail break。 原来的head.next==nul
        //如果state ！=0
        countDownLatch.await();
        System.out.println("done");
    }
}

