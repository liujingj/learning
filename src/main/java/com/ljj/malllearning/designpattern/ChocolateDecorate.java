package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/6
 */
public class ChocolateDecorate extends Decorate {

    public ChocolateDecorate(Cake cake) {
        super(cake);
    }

    public void addChocolate() {
        System.out.println("add chocolate");
    }

    @Override
    public void makeCake() {
        super.makeCake();
        addChocolate();
    }
}
