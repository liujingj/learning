package com.ljj.malllearning.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 可循环使用的屏障
 *
 * @author ljj
 * @date 2021/3/2
 */
public class CycleBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(() -> {
            try {
                //count-1 阻塞直到count=0
                cyclicBarrier.await();
                System.out.println("已到达");
            } catch (Exception e) {
            }
        }).start();

        new Thread(() -> {
            try {
                //count-1 阻塞直到count=0
                cyclicBarrier.await();
                System.out.println("已到达");
            } catch (Exception e) {
            }
        }).start();

        System.out.println("主线程");

        cyclicBarrier.reset();
    }
}
