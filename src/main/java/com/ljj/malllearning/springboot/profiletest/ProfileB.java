package com.ljj.malllearning.springboot.profiletest;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("B")
public class ProfileB implements ProfileTest {
    @Override
    public void test() {
        System.out.println("ProfileB");
    }
}
