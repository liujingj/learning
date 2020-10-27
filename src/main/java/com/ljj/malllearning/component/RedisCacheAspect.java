package com.ljj.malllearning.component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 缓存操作异常统一处理切面  避免大量重复的try catch exception
 *
 * @author ljj
 * @date 2020/10/15
 */
@Aspect
@Component
@Order(2)
public class RedisCacheAspect {
    //aop结合自定义注解

    @Pointcut("execution(public * com.ljj.malllearning.service.cacheService.*.*(..)) || execution(protected * com.ljj.malllearning.service.cacheService.*.*(..)))")
    public void cacheAspect() {

    }

    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //缓存操作失败
        //返回null 然后可以继续操作数据库 缓存操作不影响主体业务逻辑
        //如果有@CacheException注解则直接抛出异常
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            if (method.isAnnotationPresent(CacheException.class)) {
                throw throwable;
            }
            return null;
        }
    }
}
