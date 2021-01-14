package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/12
 */
public class EmpElement extends AbstractElement {

    private String personalWork;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getPersonalWork() {
        return personalWork;
    }

    public void setPersonalWork(String personalWork) {
        this.personalWork = personalWork;
    }
}
