package com.ljj.malllearning.springboot.conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;
//只能标注在方法上面
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {

    String name();

    String value();
}

