package com.ljj.malllearning.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TestJavac {
    public static boolean test() {
        Predicate<List> predicate = (v -> v.size() == 5);
        boolean result = predicate.test(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(result);
        return result;
    }
}