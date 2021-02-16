package com.ljj.malllearning.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义锁 共享式 同一时刻最多有两个线程可以同时访问
 *
 * @author ljj
 * @date 2021/2/5
 */
public class MyLock implements Lock {
    private static class Sync extends AbstractQueuedSynchronizer {
        public Sync(int state) {
            setState(state);
        }
        @Override
        protected int tryAcquireShared(int arg) { //共享式 获取同步状态
            for (; ; ) {
                int currentState = getState();
                int newState = currentState - arg;
                if (newState < 0 || compareAndSetState(currentState, newState)) {
                    return newState;
                }
            }
        }
        @Override
        protected boolean tryReleaseShared(int arg) { //共享式 释放同步状态
            for (; ; ) {
                int currentState = getState();
                int newState = currentState + arg;
                if (compareAndSetState(currentState, newState)) {
                    return true;
                }
            }
        }
    }
    private final Sync sync = new Sync(2);

    @Override
    public void lock() {
        //不支持重入
        sync.acquireShared(1);
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return true;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
