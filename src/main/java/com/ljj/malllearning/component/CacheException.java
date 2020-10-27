package com.ljj.malllearning.component;

import java.lang.annotation.*;

/**
 * @author ljj
 * @date 2020/10/15
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
//使用在方法上不能使用在接口的方法上 因为实现类只能获取自己方法上的注解不能获取实现的接口上的注解
@Target({ElementType.METHOD})
public @interface CacheException {
}
