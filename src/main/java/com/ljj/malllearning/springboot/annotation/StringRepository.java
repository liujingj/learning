package com.ljj.malllearning.springboot.annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@Repository
public @interface StringRepository {
    /**
     * 属性方法名必须与Compnent#value()保持一致
     * @return
     */
    String value() default "stringRepository";
}

