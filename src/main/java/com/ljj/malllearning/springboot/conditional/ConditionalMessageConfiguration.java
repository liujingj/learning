package com.ljj.malllearning.springboot.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalMessageConfiguration {

    @ConditionalOnSystemProperty(name="language",value="Chinese")
    @Bean("message")
    public String chineseMessage(){
        return "你好，世界";
    }

    @ConditionalOnSystemProperty(name="language",value="English")
    @Bean("message")
    public String englishMessage(){
        return "hello,world";
    }
}

