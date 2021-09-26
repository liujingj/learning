package com.ljj.malllearning;

import com.ljj.malllearning.springboot.profiletest.ProfileTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;

@Configuration
@ComponentScan(basePackageClasses = ProfileTest.class)
public class ProfileBootStrap {

    static{
        //等同于 ConfigurableEnvironment.setActiveProfiles("A)
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME,"A");
        //等同于 ConfigurableEnvironment.setDefaultProfiles("A)
        System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME,"B");
    }

    public void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.register(ProfileBootStrap.class);
        context.refresh();
        ProfileTest profileTest=context.getBean(ProfileTest.class);
        profileTest.test();
        context.close();

    }
}
