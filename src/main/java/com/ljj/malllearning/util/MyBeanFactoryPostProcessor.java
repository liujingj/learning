package com.ljj.malllearning.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 容器级别
 *
 * @author ljj
 * @date 2020/11/11
 */
//@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        System.out.println("--------第一步 容器级别 只在扫描包创建bean时执行一次(如果多次扫描包会调用多次) BeanFactoryPostProcessor.postProcessBeanFactory()");
    }
}
