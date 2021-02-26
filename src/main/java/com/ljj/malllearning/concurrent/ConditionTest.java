package com.ljj.malllearning.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ljj
 * @date 2021/2/19
 */
public class ConditionTest {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void conditionAwait() throws InterruptedException {
        lock.lock();
        try {
            //do something
            //object.wait()
            //当前线程会释放锁 并等待 其他线程调用signal通知此线程后获得锁后才返回
            condition.await();
        } finally {
            lock.unlock();
        }
    }

    public void conditionSignal() {
        lock.lock();
        try {
            //do something
            //object.notify()
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }
}
