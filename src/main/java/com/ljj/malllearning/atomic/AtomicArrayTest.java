package com.ljj.malllearning.atomic;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author ljj
 * @date 2021/3/1
 */
public class AtomicArrayTest {

    public static void main(String[] args) {
        int[] array = new int[] {0, 0};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(array);
        //第一个参数为 index
        atomicIntegerArray.getAndAdd(0, 1);
        System.out.println(atomicIntegerArray.addAndGet(0, 1));

        atomicIntegerArray.getAndAdd(1, 3);
        System.out.println(atomicIntegerArray.addAndGet(1, 2));

        System.out.println(Arrays.toString(array));
    }
}
