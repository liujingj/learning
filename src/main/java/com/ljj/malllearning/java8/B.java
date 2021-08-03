package com.ljj.malllearning.java8;

/**
 * @author ljj
 * @date 2021/6/30
 */
public interface B extends A{
    @Override
    default void hello() {
        System.out.println("B");
    }
}
