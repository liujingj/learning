package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/12
 */
public class VisitorImpl implements Visitor {

    @Override
    public void visit(EmpElement empElement) {
        System.out.println("管理者访问员工信息=" + empElement.getName() + "-" + empElement.getWork() + "-" + empElement.getPersonalWork());
    }

    @Override
    public void visit(ManagerElement managerElement) {
        System.out.println("老板访问管理者信息=" + managerElement.getName() + "-" + managerElement.getWork() + "-" + managerElement.getTeamWork());
    }
}
