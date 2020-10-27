package com.ljj.malllearning.component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * @author ljj
 * @date 2020/10/14
 */
public class FlagValidatorClass implements ConstraintValidator<FlagValidator, Integer> {

    private String[] values;

    @Override
    public void initialize(FlagValidator flagValidator) {
        //定义的值
        this.values = flagValidator.value();
    }

    /**
     * 校验逻辑
     *
     * @param value                      真实传的值
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }
        //注解校验 避免重复校验逻辑
        return Arrays.asList(values).contains(value);
    }
}
