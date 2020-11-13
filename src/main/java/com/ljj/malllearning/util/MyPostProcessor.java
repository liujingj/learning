package com.ljj.malllearning.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ljj
 * @date 2020/11/10
 */
@Order(value = 1)
@Component
public class MyPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {


    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        // TODO: 2020/11/10 第一步 
        System.out.println("MyPostProcessor.postProcessBeforeInstantiation");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        // TODO: 2020/11/10 第三步 
        System.out.println("MyPostProcessor.postProcessAfterInstantiation");
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        // TODO: 2020/11/10 第四步
        System.out.println("MyPostProcessor.postProcessProperties");
        return pvs;
    }
}
