package com.ljj.malllearning.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author ljj
 * @date 2020/12/14
 */
@Aspect
public class MyAop {

    @Pointcut("execution(* com.ljj.malllearning.util.*.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("---------myAop,jointPoint=" + joinPoint.toString());
    }
}
