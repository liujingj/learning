package com.ljj.malllearning.concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @author ljj
 * @date 2021/1/15
 */
public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReadLock readLock = readWriteLock.readLock();
        readLock.lock();
        readLock.unlock();

        WriteLock writeLock = readWriteLock.writeLock();
        writeLock.lock();
        writeLock.unlock();
    }
}
