package com.ljj.malllearning;

import com.ljj.malllearning.springboot.conditional.ConditionalMessageConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionalOnSystemPropertyBootstrap {

    public void main(String[] args) {
        System.setProperty("language", "Chinese");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConditionalMessageConfiguration.class);
        context.refresh();
        String message = context.getBean("message", String.class);
        System.out.println("message 对象=" + message);
        context.close();
    }

}
