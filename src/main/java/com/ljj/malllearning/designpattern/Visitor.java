package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/12
 */
public interface Visitor {

    void visit(EmpElement empElement);

    void visit(ManagerElement managerElement);

}
