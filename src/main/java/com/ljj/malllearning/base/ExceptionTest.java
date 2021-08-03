package com.ljj.malllearning.base;

/**
 * @author ljj
 * @date 2021/8/3
 */
public class ExceptionTest {

    public static void main(String[] args) {
        try {
            test1();
        } catch (Exception e) {
            System.out.println("main catch");
        } finally {
            System.out.println("main finally");
        }
    }

    public static boolean test1() {
        try {
            return test2();
        } catch (Exception e) {
            System.out.println("test1 catch");
            throw e;
        } finally {
            System.out.println("test1 finally");
            return false;
        }
    }

    public static boolean test2() {
        boolean result = false;
        try {
            System.out.println(1 / 0);
            result = true;
            return result;
        } catch (Exception e) {
            System.out.println("test2 catch");
            throw e;
        } finally {
            System.out.println("test2 finally");
            return result;
        }
    }
}
