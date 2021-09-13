package com.ljj.malllearning.springboot;

import com.ljj.malllearning.springboot.annotation.TransactionalService;

@TransactionalService(value="transactionalServiceBean")
public class TransactionalServiceBean {

    public void save() {
        System.out.println("保存操作");
    }
}

