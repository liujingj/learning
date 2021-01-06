package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/6
 */
public class MilkDecorate extends Decorate {

    public MilkDecorate(Cake cake) {
        super(cake);
    }

    public void addMike() {
        System.out.println("add milk");
    }

    @Override
    public void makeCake() {
        super.makeCake();
        addMike();
    }
}
