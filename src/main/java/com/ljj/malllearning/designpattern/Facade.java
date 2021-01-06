package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/6
 */
public class Facade {

    private Cook cook = new CookImpl();

    public void cook() {
        cook.washVegetables();
        cook.cooking();
        cook.washDish();
    }
}
