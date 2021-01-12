package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/12
 */
public class ObserverClient {
    public static void main(String[] args) {
        //被观察者
        LoginSubject loginSubject = new LoginSubject();
        //观察者
        StatisticsObserver statisticsObserver = new StatisticsObserver(loginSubject);
        OperateObserver operateObserver = new OperateObserver(loginSubject);

        loginSubject.login(123L);
    }
}
