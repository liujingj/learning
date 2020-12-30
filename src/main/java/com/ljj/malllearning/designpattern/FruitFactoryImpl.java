package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2020/12/30
 */
public class FruitFactoryImpl implements FruitFactoryAbs {
    @Override
    public Apple getApple() {
        return new Apple();
    }

    @Override
    public Orange getOrange() {
        return new Orange();
    }
}
