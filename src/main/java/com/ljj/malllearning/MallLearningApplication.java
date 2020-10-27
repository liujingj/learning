package com.ljj.malllearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//排除数据库的配置
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MallLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallLearningApplication.class, args);
    }

}
