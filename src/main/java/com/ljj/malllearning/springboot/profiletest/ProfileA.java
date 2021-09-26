package com.ljj.malllearning.springboot.profiletest;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("A")
public class ProfileA implements ProfileTest {
    @Override
    public void test() {
        System.out.println("ProfileA");
    }
}
