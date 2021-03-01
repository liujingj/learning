package com.ljj.malllearning.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import lombok.Data;

/**
 * @author ljj
 * @date 2021/3/1
 */
public class AtomicFieldTest {

    public static void main(String[] args) {
        AtomicIntegerFieldUpdater<User> updater = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");
        User user = new User();
        user.name = "小青";
        user.age = 20;
        updater.addAndGet(user, 1);
        System.out.println(updater.get(user));

        User newUser = new User();
        newUser.name = "小红";
        newUser.age = 18;
        updater.addAndGet(newUser, 1);
        System.out.println(updater.get(newUser));
    }

    @Data
    public static class User {
        private String name;
        //必须为 public volatile
        public volatile int age;
    }
}
