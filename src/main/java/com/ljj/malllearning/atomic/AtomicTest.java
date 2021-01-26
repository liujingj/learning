package com.ljj.malllearning.atomic;

import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ljj
 * @date 2021/1/20
 */
public class AtomicTest {

    @ToString
    public static class AtomicObj {
        private int i;
        private int j;
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicObj atomicObj = new AtomicObj();
        atomicObj.i = 1;
        atomicObj.j = 2;
        AtomicObj atomicObj1 = new AtomicObj();
        atomicObj1.i = 2;
        atomicObj1.j = 3;
        AtomicObj atomicObj2 = new AtomicObj();
        atomicObj2.i = 3;
        atomicObj2.j = 4;
        AtomicReference<AtomicObj> reference = new AtomicReference<>(atomicObj);
        reference.compareAndSet(atomicObj, atomicObj1);
        System.out.println(reference.get());

        reference.compareAndSet(atomicObj, atomicObj2);
        System.out.println(reference.get());

        reference.compareAndSet(atomicObj1, atomicObj2);
        System.out.println(reference.get());

//        AtomicInteger atomicInteger = new AtomicInteger(1);
//        new Thread(() -> {
//            System.out.println("1---" + atomicInteger.compareAndSet(1, 2));
//            System.out.println("2---" + atomicInteger.compareAndSet(2, 1));
//        }).start();
//        Thread.sleep(1000);
//        new Thread(() -> {
//            System.out.println("3---" + atomicInteger.compareAndSet(1, 2));
//        }).start();
//
//
//        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(1, 1);
//        new Thread(() -> {
//            System.out.println("4---" + atomicStampedReference.compareAndSet(1, 2, 1, 2));
//            System.out.println("5---" + atomicStampedReference.compareAndSet(2, 1, 2, 3));
//        }).start();
//        Thread.sleep(1000);
//        new Thread(() -> {
//            System.out.println("6---" + atomicStampedReference.compareAndSet(1, 2, 1, 2));
//            System.out.println("7---" + atomicStampedReference.compareAndSet(1, 2, 3, 4));
//        }).start();

    }
}
