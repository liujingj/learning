package com.ljj.malllearning.concurrent;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ljj
 * @date 2021/2/19
 */
public class BoundedQueue<T> {
    private LinkedList<T> queue = new LinkedList<>();
    private int queueSize;
    private Lock lock = new ReentrantLock();
    private Condition fullCondition = lock.newCondition();
    private Condition emptyCondition = lock.newCondition();

    public BoundedQueue(int size) {
        this.queueSize = size;
    }

    public void add(T object) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == queueSize) {
                fullCondition.await();//队列满了则等待
            }
            queue.addLast(object);
            emptyCondition.signalAll();//唤醒取元素的线程
        } finally {
            lock.unlock();
        }
    }

    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == 0) {
                emptyCondition.await();//队列空了则等待
            }
            T object = queue.removeFirst();
            fullCondition.signalAll();//唤醒添加元素的线程
            return object;
        } finally {
            lock.unlock();
        }
    }
}
