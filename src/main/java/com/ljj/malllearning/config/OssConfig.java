package com.ljj.malllearning.config;

import com.aliyun.oss.OSSClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ljj
 * @date 2020/10/12
 */
@Configuration
public class OssConfig {

    @Bean
    public OSSClient ossClient(){
        return new OSSClient("","","");
    }
}
