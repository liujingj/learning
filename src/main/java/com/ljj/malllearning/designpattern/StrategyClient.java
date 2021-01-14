package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/13
 */
public class StrategyClient {
    public static void main(String[] args) {
        StrategyContext strategyContext = new StrategyContext(new AliPay());
        strategyContext.doPay();
        strategyContext = new StrategyContext(new WeChatPay());
        strategyContext.doPay();
    }
}
