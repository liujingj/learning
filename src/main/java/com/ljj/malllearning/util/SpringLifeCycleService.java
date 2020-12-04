package com.ljj.malllearning.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 每一个Bean自身特殊的
 * BeanNameAware BeanFactoryAware 属性设置之后  InitializingBean init执行之后
 *
 * @author ljj
 * @date 2020/11/10
 */
@Component
@Lazy
public class SpringLifeCycleService implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private Apple apple;

    public SpringLifeCycleService() {
        System.out.println("--------第三步 bean1的构造方法");
    }

    @Autowired
    public void setApple(Apple apple) {
        System.out.println("--------第六步 bean1属性设置apple");
        this.apple = apple;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("-------- 第七步 属性设置之后 bean1 实现的 BeanNameAware.setBeanName()");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("--------第八步 属性设置之后 bean1 实现的 BeanFactoryAware.setBeanFactory()");
    }

    @Override
    public void destroy() {
        System.out.println("-------- 第十四步 执行destroy方法之后 bean1实现的DisposableBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("-------- 第十一步 init执行之后，bean1 实现的 InitializingBean.afterPropertiesSet()");
    }

    @PostConstruct
    public void myInit() {
        System.out.println("-------- 第十步 bean1的init方法");
    }

    @PreDestroy
    public void myDestroy() {
        System.out.println("-------- 第十三步 bean1的 destroy方法");
    }

}
