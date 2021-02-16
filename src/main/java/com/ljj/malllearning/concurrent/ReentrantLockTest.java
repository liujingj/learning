package com.ljj.malllearning.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ljj
 * @date 2021/1/15
 */
public class ReentrantLockTest {
    //lock实现 ReentrantLock ReentrantReadWriteLock StampedLock

    public static void main(String[] args) {
        //可重入锁
        Lock lock = new ReentrantLock();
        //获取锁
        lock.lock();
        try {
            //lock.lock();  错误示范 如果获取锁失败抛出异常导致也释放锁
        } finally {
            //异常时也能释放锁
            lock.unlock();
        }

        //Lock接口的实现基本都是通过同步器的子类来完成线程访问控制

    }
}
