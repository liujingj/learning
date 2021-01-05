package com.ljj.malllearning.designpattern;

/**
 * 外部需要被适配的接口
 * @author ljj
 * @date 2021/1/5
 */
public interface OutAdaptee {
    /**
     * 获取员工姓名
     */
    String getEmpName();

    /**
     * 获取部门名字
     */
    String getDeptName();
}
