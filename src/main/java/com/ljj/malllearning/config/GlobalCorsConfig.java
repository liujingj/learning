package com.ljj.malllearning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 覆盖默认的CorsFilter解决跨域问题
 *
 * @author ljj
 * @date 2020/10/14
 */
@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration configuration = new CorsConfiguration();
        //允许所有域名跨域访问
        configuration.addAllowedOrigin("*");
        //允许跨域发送cookie
        configuration.setAllowCredentials(true);
        //放行全部原始头信息
        configuration.addAllowedHeader("*");
        //允许所有请求方法跨域调用
        configuration.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return new CorsFilter(source);
    }
}
