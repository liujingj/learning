package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2020/12/30
 */
public class AppleFactory implements Factory{
    @Override
    public Fruit getFruit() {
        return new Apple();
    }
}
