package com.ljj.malllearning.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Bean级别 创建每一个Bean的时候都会执行 共有的
 * 执行init方法前后
 *
 * @author ljj
 * @date 2020/11/10
 */
//@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-------- 第九步 Bean级别(包括spring自身的Bean) 执行init方法之前 BeanPostProcessor.postProcessBeforeInitialization()");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("--------第十二步 Bean级别(包括spring自身的Bean) 执行init方法之后 BeanPostProcessor.postProcessAfterInitialization()");
        return bean;
    }
}
