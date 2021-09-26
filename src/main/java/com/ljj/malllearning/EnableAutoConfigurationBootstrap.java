package com.ljj.malllearning;

import com.ljj.malllearning.springboot.listener.DefaultAutoConfigurationImportListener;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration(exclude = {SpringApplicationAdminJmxAutoConfiguration.class})
@ComponentScan(basePackageClasses = DefaultAutoConfigurationImportListener.class)
public class EnableAutoConfigurationBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args)
                .close();
    }
}
