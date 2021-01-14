package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/13
 */
public class StrategyContext {

    private Pay pay;

    public StrategyContext(Pay pay) {
        this.pay = pay;
    }

    public void doPay() {
        this.pay.pay();
    }
}
