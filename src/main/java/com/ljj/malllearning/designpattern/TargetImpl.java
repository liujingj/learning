package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/5
 */
public class TargetImpl implements Target {
    @Override
    public String getName() {
        return "自己公司员工姓名";
    }

    @Override
    public String getDept() {
        return "自己公司员工部门";
    }
}
