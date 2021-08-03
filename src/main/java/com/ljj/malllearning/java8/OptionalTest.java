package com.ljj.malllearning.java8;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * @author ljj
 * @date 2021/6/30
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional=Optional.ofNullable(null);
        //System.out.println(optional.ifPresent(););
        System.out.println(optional.orElse("1"));
        System.out.println(optional.orElseGet(()->"1"));

    }
}
