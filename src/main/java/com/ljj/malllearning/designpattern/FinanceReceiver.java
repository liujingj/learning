package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/7
 */
public class FinanceReceiver implements Receiver {
    @Override
    public void reportWork() {
        System.out.println("财务经理来汇报工作");

    }

    @Override
    public void assigningWork() {
        System.out.println("给财务经理分配新任务");

    }
}
