package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/11
 */
public class Tenant extends AbstractColleague {

    public Tenant(AbstractMediator abstractMediator) {
        super(abstractMediator);
    }

    //租客租房子只需要通过中介来实现 不需要与房东直接联系
    public void rent() {
        abstractMediator.execute();
    }
}
