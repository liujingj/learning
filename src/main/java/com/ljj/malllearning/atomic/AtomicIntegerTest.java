package com.ljj.malllearning.atomic;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ljj
 * @date 2021/3/1
 */
public class AtomicIntegerTest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        //新增 返回新的值
        System.out.println(atomicInteger.addAndGet(1));
        //新增 返回旧的值
        System.out.println(atomicInteger.getAndAdd(2));
        //比较期望的值相同 则更新 返回是否成功
        System.out.println(atomicInteger.compareAndSet(3, 5));
        //自增1 返回旧的值
        System.out.println(atomicInteger.getAndIncrement());
        //以上4个方法底层调用的都是unsafe的方法compareAndSwapInt
    }
}
