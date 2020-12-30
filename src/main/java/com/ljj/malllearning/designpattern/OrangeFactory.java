package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2020/12/30
 */
public class OrangeFactory implements Factory{
    @Override
    public Fruit getFruit() {
        return new Orange();
    }
}
