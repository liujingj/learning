package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/5
 */
public abstract class EmpBaseInfo {
    private String name;
    private String dept;
    private String salary;

    public EmpBaseInfo(String name, String dept, String salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public void getEmpInfo() {
        System.out.println("name=" + name + ",dept=" + dept + ",salary=" + salary);
    }
}
