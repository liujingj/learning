package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/12
 */
public class OperateObserver implements Observer {

    public OperateObserver(Subject subject) {
        subject.addObserver(this);
    }

    @Override
    public void execute(Long userId) {
        System.out.println("运营平台监听到用户登录");
    }
}
