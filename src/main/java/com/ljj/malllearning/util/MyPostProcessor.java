package com.ljj.malllearning.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Bean级别 创建每一个Bean的时候都会执行 共有的
 * 执行构造方法前后
 *
 * @author ljj
 * @date 2020/11/10
 */
@Component
public class MyPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {


    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("--------第二步 Bean级别(包括spring自身的Bean) 执行构造方法之前 InstantiationAwareBeanPostProcessorAdapter.postProcessBeforeInstantiation()");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("--------第四步 Bean级别(包括spring自身的Bean) 执行构造方法之后 InstantiationAwareBeanPostProcessorAdapter.postProcessAfterInstantiation()");
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println("--------第五步 Bean级别(包括spring自身的Bean) 设置属性之前 InstantiationAwareBeanPostProcessorAdapter.postProcessProperties()");
        return pvs;
    }
}
