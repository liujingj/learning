package com.ljj.malllearning.base;

/**
 * @author ljj
 * @date 2021/8/3
 */
public class ExceptionTest1 {

    public static void main(String[] args) {
        try {

            test1();
        } catch (Exception e) {
            System.out.println("main catch");
        } finally {
            System.out.println("main finally");
        }
    }

    public static void test1() {
        try {
            test2();
        } catch (Exception e) {
            System.out.println("test1 catch");
            throw e;
        } finally {
            System.out.println("test1 finally");
        }
    }

    public static void test2() {
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            System.out.println("test2 catch");
            throw e;
        } finally {
            System.out.println("test2 finally");
        }
    }
}
