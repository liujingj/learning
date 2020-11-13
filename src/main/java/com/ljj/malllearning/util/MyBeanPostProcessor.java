package com.ljj.malllearning.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ljj
 * @date 2020/11/10
 */
@Order(value = 2)
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // TODO: 2020/11/10 第八步
        System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // TODO: 2020/11/10 第十一步
        System.out.println("MyBeanPostProcessor.postProcessAfterInitialization");
        return bean;
    }
}
