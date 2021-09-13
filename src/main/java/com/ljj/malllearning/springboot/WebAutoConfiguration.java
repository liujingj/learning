package com.ljj.malllearning.springboot;


import com.ljj.malllearning.WebConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 自动装配类
 */
@Configuration
@Import(WebConfiguration.class)
public class WebAutoConfiguration {

}
