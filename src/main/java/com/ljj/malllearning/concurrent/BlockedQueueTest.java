package com.ljj.malllearning.concurrent;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedTransferQueue;

/**
 * @author ljj
 * @date 2021/2/23
 */
public class BlockedQueueTest {

    public static void main(String[] args) throws InterruptedException {
        //数组结构的 有界阻塞队列 默认非公平 不保证先阻塞的线程先访问队列
        //ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
        //arrayBlockingQueue.put("");
        //arrayBlockingQueue.take();

        //链表结构的有界阻塞队列
        //LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        //linkedBlockingQueue.put("");
        //linkedBlockingQueue.take();

        //支持优先级排序的无界阻塞队列 可以指定元素排序规则 无界-数组扩容 没有阻塞
        //PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
        //priorityBlockingQueue.put("");
        //priorityBlockingQueue.take();

        //支持延时获取元素的无界阻塞队列 队列使用PriorityQueue实现
        //用于定时任务调度 缓存有效期存储  TimerQueue就是用DelayQueue实现的
        //队列中的元素必须实现Delayed接口 在创建元素时可以指定多久才能从队列中获取元素 只有在延时期满才能获取元素
        //DelayQueue delayQueue = new DelayQueue();
        //delayQueue.take();

        //不存储元素的阻塞队列 每一个put必须对应一个take 吞吐量高于 ArrayBlockingQueue  LinkedBlockingQueue
        //SynchronousQueue synchronousQueue = new SynchronousQueue();
        //new Thread(() -> {
        //    try {
        //        synchronousQueue.put(1);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}).start();
        //Thread.sleep(20 * 1000);
        //new Thread(() -> {
        //    try {
        //        synchronousQueue.put(2);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}).start();
        //Thread.sleep(10 * 1000);
        //new Thread(() -> {
        //    try {
        //        synchronousQueue.take();
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}).start();
        //Thread.sleep(2 * 60 * 1000);
        //new Thread(() -> {
        //    try {
        //        synchronousQueue.take();
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}).start();

        //链表结构的无界阻塞队列 如果有消费者正在等在接收元素 生产者可以直接把传入的元素传递给消费者，如果没有消费者则放在tail节点 等到被消费了才能返回
        //LinkedTransferQueue linkedTransferQueue = new LinkedTransferQueue();
        //linkedTransferQueue.put("1");
        //linkedTransferQueue.put("2");
        //linkedTransferQueue.put("3");
        //linkedTransferQueue.put("4");
        //linkedTransferQueue.take();
        //linkedTransferQueue.take();
        //linkedTransferQueue.take();
        //linkedTransferQueue.take();

        //new Thread(() -> {
        //    try {
        //        linkedTransferQueue.take();
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}).start();
        //Thread.sleep(2*60 * 1000);
        //new Thread(() -> {
        //    try {
        //        linkedTransferQueue.take();
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}).start();
        //Thread.sleep(1 * 60 * 1000);
        //linkedTransferQueue.put("4");
        //Thread.sleep(5 * 60 * 1000);
        //linkedTransferQueue.put("5");
        //linkedTransferQueue.put("6");

        //linkedTransferQueue.put("1");
        //linkedTransferQueue.put("2");
        //linkedTransferQueue.put("3");
        //linkedTransferQueue.take();
        //linkedTransferQueue.take();
        //linkedTransferQueue.take();
        //linkedTransferQueue.take();

        //链表结构的双向阻塞队列 双向-可以从列表的两端插入和取出元素
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        linkedBlockingDeque.putLast("");
        linkedBlockingDeque.putFirst("");

        linkedBlockingDeque.takeFirst();
        linkedBlockingDeque.takeLast();

    }
}
