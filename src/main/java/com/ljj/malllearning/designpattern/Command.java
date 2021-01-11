package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/7
 */
public abstract class Command {
    //真正执行命令的接收者
    HRReceiver hrReceiver = new HRReceiver();
    FinanceReceiver financeReceiver = new FinanceReceiver();
    SaleReceiver saleReceiver = new SaleReceiver();

    abstract void execute();
}
