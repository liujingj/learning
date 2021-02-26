package com.ljj.malllearning.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONObject;

/**
 * @author ljj
 * @date 2021/2/18
 */
public class FairAndUnfairLockTest {

    static MyReentrantLock fair = new MyReentrantLock(true);
    static MyReentrantLock unfair = new MyReentrantLock(false);

    public static void testFairAndUnfair(MyReentrantLock lock) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                lock.lock();
                System.out.println("lock by " + Thread.currentThread().getName() + "waiting by" + JSONObject.toJSONString(
                        lock.getQueuedThreads().stream().map(Thread::getName).collect(Collectors.toList())));
                lock.unlock();
            }).start();
        }
    }

    public static class MyReentrantLock extends ReentrantLock {
        public MyReentrantLock(boolean fair) {
            super(fair);
        }

        @Override
        protected Collection<Thread> getQueuedThreads() {
            List<Thread> list = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(list);
            return list;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("fair lock--------");
        testFairAndUnfair(fair);
        Thread.sleep(1 * 1000);
        System.out.println("unfair lock---------");
        testFairAndUnfair(unfair);
    }
}
