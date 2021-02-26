package com.ljj.malllearning.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author ljj
 * @date 2021/2/23
 */
public class ConcurrentLinkedQueueTest {
    public static void main(String[] args) {
        //无界队列 不会阻塞
        ConcurrentLinkedQueue linkedQueue = new ConcurrentLinkedQueue();

        //抛出异常
        linkedQueue.add("");
        linkedQueue.remove();

        //返回特殊值
        //入队列
        linkedQueue.offer("");
        //出队列
        linkedQueue.poll();

    }
}
