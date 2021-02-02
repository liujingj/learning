package com.ljj.malllearning.concurrent;

/**
 * @author ljj
 * @date 2021/1/27
 */
public class SyncTest {
    private volatile boolean flag = true;

    public void testSync() {
        synchronized (this) {
            System.out.println("--testSync");

        }
    }

    public void testReadVolatile() {
        while (flag) {
            System.out.println("--testVolatile");
        }
    }

    public void testWriteVolatile() {
        System.out.println("--testSync");
        flag = false;
    }

    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest();
        new Thread(() -> syncTest.testReadVolatile()).start();
        new Thread(() -> syncTest.testWriteVolatile()).start();
        new Thread(() -> syncTest.testSync()).start();

    }
}
