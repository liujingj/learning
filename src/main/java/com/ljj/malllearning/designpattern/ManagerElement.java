package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/12
 */
public class ManagerElement extends AbstractElement {

    private String teamWork;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getTeamWork() {
        return teamWork;
    }

    public void setTeamWork(String teamWork) {
        this.teamWork = teamWork;
    }
}
