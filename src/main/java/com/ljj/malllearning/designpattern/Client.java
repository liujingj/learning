package com.ljj.malllearning.designpattern;

import java.util.List;

/**
 * @author ljj
 * @date 2021/1/5
 */
public class Client {
    public static void main(String[] args) {
        ManagerComposite root = new ManagerComposite("总经理", "总裁办", "100");
        EmpLeaf mishu = new EmpLeaf("秘书", "总裁办", "10");
        ManagerComposite jingli = new ManagerComposite("部门经理", "研发部", "50");
        //总经理下面有秘书和部门经理
        root.addEmp(mishu);
        root.addEmp(jingli);
        //部门经理下面有两个员工
        EmpLeaf xiaohong = new EmpLeaf("小红", "研发部", "20");
        EmpLeaf xiaohei = new EmpLeaf("小黑", "研发部", "20");
        jingli.addEmp(xiaohong);
        jingli.addEmp(xiaohei);
        getEmpInfo(root);
    }

    public static void getEmpInfo(ManagerComposite root) {
        root.getEmpInfo();
        List<EmpBaseInfo> under = root.getUnderList();
        for (EmpBaseInfo info : under) {
            if (info instanceof ManagerComposite) {
                getEmpInfo((ManagerComposite) info);
            } else {
                info.getEmpInfo();
            }
        }
    }
}
