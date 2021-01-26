package com.ljj.malllearning.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ljj
 * @date 2021/1/15
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService=Executors.newFixedThreadPool(1);
    }
}
