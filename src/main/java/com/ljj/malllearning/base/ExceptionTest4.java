package com.ljj.malllearning.base;

/**
 * @author ljj
 * @date 2021/8/3
 */
public class ExceptionTest4 {

    public static void main(String[] args) {
        System.out.println(test2());
    }

    public static int test2() {
        int a = 10;
        int b = 9;
        int c = a + b;
        try {
            return c;
        } finally {
            c = 20;
        }
    }
}
