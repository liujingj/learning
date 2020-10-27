package com.ljj.malllearning.component;

import com.alibaba.fastjson.JSONObject;
import com.ljj.malllearning.dto.WebLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.classfile.Signature;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author ljj
 * @date 2020/10/13
 */
@Aspect
@Component
@Order(1)
@Slf4j
public class WebLogAspect {
    //advice通知-通知描述了切面要完成的工作以及何时执行   前置通知 后置通知 返回通知 异常通知 环绕通知   @Before @After @AfterReturning @AfterThrowing @Around
    //pointCut切点-通知功能被应用的范围  @PointCut定义切点 execution(方法修饰符 返回类型 方法所属的包.类名.方法名(方法参数))
    //aspect切面-通知和切点的结合   @Aspect定义切面
    //weaving织入-把切面应用到目标对象并创建新的代理对象的过程

    //切点
    @Pointcut("execution(public * com.ljj.malllearning.controller.*.*(..))")
    public void webLog() {

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {

    }

    @AfterReturning(value = "webLog()", returning = "obj")
    public void doAfterReturning(Object obj) {

    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        Long end = System.currentTimeMillis();

        //记录请求信息
        WebLog webLog = new WebLog();
        //获取当前请求对象
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        request.getRequestURL().toString();
        request.getRemoteHost();
        request.getMethod();

        joinPoint.getArgs();

        webLog.setResult(result);
        webLog.setUserName(request.getRemoteUser());
        webLog.setTime(end - begin);

        //将日志格式化成json输出
        log.info(JSONObject.toJSONString(webLog));
        return result;

        //ELK日志收集  elasticsearch-存储收集到的日志   logstash收集日志 再转发给elasticsearch kibana通过web端查看日志
        //
    }
}
