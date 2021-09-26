package com.ljj.malllearning.springboot.annotation;

import com.ljj.malllearning.springboot.Server;
import com.ljj.malllearning.springboot.ServerImportBeanDefinitionRegistrar;
import com.ljj.malllearning.springboot.ServerImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ServerImportBeanDefinitionRegistrar.class)
public @interface EnableServer {

    Server.Type type();
}

