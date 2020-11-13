package com.ljj.malllearning.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author ljj
 * @date 2020/11/11
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    // TODO: 2020/11/11 第0步
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor.postProcessBeanFactory");
    }
}
