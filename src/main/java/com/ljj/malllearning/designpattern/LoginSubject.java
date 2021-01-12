package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/12
 */
public class LoginSubject extends Subject {

    @Override
    public void addObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObserver(Long userId) {
        for (Observer observer : list) {
            observer.execute(userId);
        }
    }

    public void login(Long userId) {
        notifyObserver(userId);
    }
}
