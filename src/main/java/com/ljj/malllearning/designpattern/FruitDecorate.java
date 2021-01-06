package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/6
 */
public class FruitDecorate extends Decorate {
    public FruitDecorate(Cake cake) {
        super(cake);
    }

    public void addFruit() {
        System.out.println("add fruit");
    }

    @Override
    public void makeCake() {
        super.makeCake();
        addFruit();
    }
}
