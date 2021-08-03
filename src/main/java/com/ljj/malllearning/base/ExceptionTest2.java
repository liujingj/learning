package com.ljj.malllearning.base;

/**
 * @author ljj
 * @date 2021/8/3
 */
public class ExceptionTest2 {

    public static void main(String[] args) {
        test1();
    }

    public static boolean test1() {
        System.out.println(test2());
        return test2();
    }

    public static boolean test2() {
        try {
            System.out.println(1 / 0);
            return true;
        } catch (Exception e) {
            System.out.println("test2 catch");
            return false;
        } finally {
            System.out.println("test2 finally");
            return true;
        }
    }
}
