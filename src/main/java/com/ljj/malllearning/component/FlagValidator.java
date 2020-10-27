package com.ljj.malllearning.component;

import java.lang.annotation.*;

/**
 * 自定义注解
 *
 * @author ljj
 * @date 2020/10/14
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
//使用在属性或参数上
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface FlagValidator {
    String[] value() default {};

    String message() default "flag is not found";

}
