package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/11
 */
public class LandLord extends AbstractColleague {

    public LandLord(AbstractMediator abstractMediator) {
        super(abstractMediator);
    }

    //房东出租只需要通过中介来实现 不需要与租客直接联系
    public void rental() {
        abstractMediator.execute();
    }

}
