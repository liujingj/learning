package com.ljj.malllearning.designpattern;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 适配器类 实现目标类，将外部类结构转换成目标类结构
 * @author ljj
 * @date 2021/1/5
 */
public class Adapter implements Target {

    @Autowired
    private OutAdaptee outAdaptee;

    @Override
    public String getName() {
        return outAdaptee.getEmpName();
    }

    @Override
    public String getDept() {
        return outAdaptee.getDeptName();
    }
}
