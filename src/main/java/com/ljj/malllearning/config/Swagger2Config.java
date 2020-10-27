package com.ljj.malllearning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

/**
 * swagger 配置类
 *
 * @author ljj
 * @date 2020/9/27
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.ljj.malllearning.controller"))//api文档扫描的包
                .paths(PathSelectors.any()).build()
                //添加登录认证
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("swagger-ui演示").description("swagger").version("0.1").build();
    }

    private List<ApiKey> securitySchemes() {
        // 设置请求头信息
        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "header");
        return Arrays.asList(apiKey);
    }

    private List<SecurityContext> securityContexts() {
        //设置需要登录认证的路径
        return Arrays.asList(getContextByPath("/brand/*"));

    }

    private SecurityContext getContextByPath(String pathRegex) {
        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex(pathRegex)).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        return Arrays.asList(new SecurityReference("Authorization", new AuthorizationScope[]{authorizationScope}));
    }
}
