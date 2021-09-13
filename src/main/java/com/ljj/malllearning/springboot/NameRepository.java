package com.ljj.malllearning.springboot;


import com.ljj.malllearning.springboot.annotation.StringRepository;

import java.util.Arrays;
import java.util.List;

@StringRepository
public class NameRepository {
    public List<String> findAll(){
        return Arrays.asList("张三","李四");
    }
}

