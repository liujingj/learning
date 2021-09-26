package com.ljj.malllearning.springboot;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

public class ServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //复用ServerImportSelector
        ImportSelector importSelector=new ServerImportSelector();
        //筛选class名称集合
        String[] selectedClassNames=importSelector.selectImports(importingClassMetadata);
        //创建Bean定义
        Stream.of(selectedClassNames)
                .map(BeanDefinitionBuilder::genericBeanDefinition)
                .map(BeanDefinitionBuilder::getBeanDefinition)
                .forEach(beanDefinition->{
                    //注册BeanDefinition到BeanDefinitionRegistry
                    BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition,registry);
                });

    }
}

