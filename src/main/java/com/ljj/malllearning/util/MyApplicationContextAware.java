package com.ljj.malllearning.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author ljj
 * @date 2020/11/11
 */
//@Component
public class MyApplicationContextAware implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("==================实现了 ApplicationContextAware setApplicationContext");
    }
}
