package com.ljj.malllearning;

/**
 * @author ljj
 * @date 2021/2/24
 */
public class Test {
    public static class Father {
        int age = 40;

        public Father() {
            age = 41;
            test();
        }

        public void test() {
            System.out.println("i am father,my age is" + age);
        }
    }

    public static class Son extends Father {
        int age = 10;

        public Son() {
            age = 11;
            test();
        }

        @Override
        public void test() {
            System.out.println("i am son,my age is" + age);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Father son = new Son();
        System.out.println("son age is" + son.age);
    }
}
