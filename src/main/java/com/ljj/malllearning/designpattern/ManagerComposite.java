package com.ljj.malllearning.designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljj
 * @date 2021/1/5
 */
public class ManagerComposite extends EmpBaseInfo {
    //管理者的属下
    List<EmpBaseInfo> list = new ArrayList<>();

    public ManagerComposite(String name, String dept, String salary) {
        super(name, dept, salary);
    }

    //管理者新增属下 属下可能是管理者也可能是员工
    public void addEmp(EmpBaseInfo empBaseInfo) {
        list.add(empBaseInfo);
    }

    //查询属下员工信息
    public List<EmpBaseInfo> getUnderList() {
        return list;
    }
}
