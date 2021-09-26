package com.ljj.malllearning;


import com.ljj.malllearning.springboot.annotation.EnableHelloWorld;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
//@Configuration
//@EnableHelloWorld
public class EnableHelloWorldBootstrap {

    public void main(String[] args) {
        //构建Annotation配置驱动Spring上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册当前引导类到spring上下文
        context.register(EnableHelloWorldBootstrap.class);
        //启动上下文
        context.refresh();
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println("helloWorld=" + helloWorld);
        context.close();

    }
}


