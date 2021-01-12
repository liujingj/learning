package com.ljj.malllearning.designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljj
 * @date 2021/1/12
 */
//被观察者
public abstract class Subject {

    //观察者
    protected List<Observer> list = new ArrayList<>();

    //添加观察者
    public abstract void addObserver(Observer observer);

    //移除观察者
    public abstract void removeObserver(Observer observer);

    //通知观察者
    public abstract void notifyObserver(Long userId);

}
