package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/12
 */
public class VisitorClient {
    public static void main(String[] args) {

        Visitor visitor = new VisitorImpl();
        EmpElement empElement = new EmpElement();
        empElement.setName("小红");
        empElement.setWork("java");
        empElement.setPersonalWork("个人工作");
        empElement.accept(visitor);

        ManagerElement managerElement = new ManagerElement();
        managerElement.setName("大黑");
        managerElement.setWork("团队管理");
        managerElement.setTeamWork("团队工作");
        managerElement.accept(visitor);
    }
}
