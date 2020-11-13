package com.ljj.malllearning.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 缺点：业务和spring框架耦合度比较高
 * @author ljj
 * @date 2020/11/10
 */
@Component
public class SpringLifeCycleService implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name;
    private int time;

    public SpringLifeCycleService() {
        // TODO: 2020/11/10 第二步 
        System.out.println("构造方法");
    }

    public void setName(String name) {
        // TODO: 2020/11/10 第五步
        System.out.println("属性设置name");
        this.name = name;
    }

    public void setTime(int time) {
        System.out.println("属性设置time");
        this.time = time;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        // TODO: 2020/11/10 第七步
        System.out.println("setBeanFactory");
    }

    @Override
    public void setBeanName(String s) {
        // TODO: 2020/11/10 第六步
        System.out.println("setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        // TODO: 2020/11/10 第十二步
        System.out.println("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO: 2020/11/10 第九步
        System.out.println("afterPropertiesSet");
    }

    @PostConstruct
    public void myInit() {
        // TODO: 2020/11/10 第十步
        System.out.println("myInit");
    }

    @PreDestroy
    public void myDestroy() {
        // TODO: 2020/11/10 第十三步
        System.out.println("myDestroy");
    }
}
