package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/7
 */
public class HRReceiver implements Receiver {

    @Override
    public void reportWork() {
        System.out.println("人事经理来汇报工作");
    }

    @Override
    public void assigningWork() {
        System.out.println("给人事经理分配新任务");
    }
}
