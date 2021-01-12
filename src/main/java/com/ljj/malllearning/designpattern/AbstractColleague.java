package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/11
 */
public abstract class AbstractColleague {

    protected AbstractMediator abstractMediator;
    protected int price;

    public AbstractColleague(AbstractMediator abstractMediator) {
        this.abstractMediator = abstractMediator;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
