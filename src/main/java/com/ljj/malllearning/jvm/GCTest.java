package com.ljj.malllearning.jvm;

/**
 * @author ljj
 * @date 2021/2/16
 */
public class GCTest {

    private Object field;
    public static void main(String[] args) {
        GCTest obj1 = new GCTest();
        GCTest obj2 = new GCTest();
        obj1.field = obj2;
        obj2.field = obj1;
        obj1 = null;
        obj2 = null;
        System.gc();
    }
}
