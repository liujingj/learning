package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/12
 */
public class StatisticsObserver implements Observer {

    public StatisticsObserver(Subject subject) {
        subject.addObserver(this);
    }

    @Override
    public void execute(Long userId) {
        System.out.println("统计平台监听到用户登录");
    }
}
