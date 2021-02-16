package com.ljj.malllearning.jvm;

/**
 * stackOverFlow
 * @author ljj
 * @date 2021/2/1
 */
public class SOFTest {
    public static void main(String[] args) {
        //递归
        add(0);
    }

    public static void add(int i) {
        i++;
        add(i);
    }
}
