package com.ljj.malllearning.atomic;

import java.util.concurrent.atomic.AtomicReference;

import lombok.Data;

/**
 * @author ljj
 * @date 2021/3/1
 */
public class AtomicReferenceTest {
    public static void main(String[] args) {
        AtomicReference<User> atomicReference = new AtomicReference<>();
        User user = new User();
        user.name = "小红";
        user.age = 18;
        atomicReference.getAndSet(user);

        User newUser = new User();
        newUser.name = "小青";
        newUser.age = 20;
        atomicReference.compareAndSet(user, newUser);
        System.out.println(atomicReference.get().toString());

    }

    @Data
    public static class User {
        private String name;
        private int age;
    }
}
