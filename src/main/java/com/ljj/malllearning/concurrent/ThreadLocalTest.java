package com.ljj.malllearning.concurrent;

/**
 * @author ljj
 * @date 2021/2/1
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<Long> time = new ThreadLocal<>();
        time.get();
        time.set(1L);
        time.remove();

    }

    public <T, R> R test(T param, R result) {
        return result;
    }
}
