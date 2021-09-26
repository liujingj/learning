package com.ljj.malllearning.springboot.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.Objects;

public class OnSystemPropertyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取@ConditionalOnSystemProperty所有的属性方法值
        MultiValueMap<String,Object> attributes=metadata.getAllAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        String propertyName=(String)attributes.getFirst("name");
        String propertyValue=(String)attributes.getFirst("value");
        String systemPropertyValue=System.getProperty(propertyName);
        if(Objects.equals(systemPropertyValue,propertyValue)){
            System.out.printf("系统属性[名称：%s]，找到匹配值：%s\n",propertyName,systemPropertyValue);
            return true;
        }
        return false;
    }
}

