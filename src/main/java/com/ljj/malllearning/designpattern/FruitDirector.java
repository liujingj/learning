package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/3
 */
public class FruitDirector {
    private FruitBuilder fruitBuilder;

    public FruitDirector(FruitBuilder fruitBuilder) {
        this.fruitBuilder = fruitBuilder;
    }

    public FruitProduct buildA() {
        fruitBuilder.buildApple().buildBanana();
        return fruitBuilder.build();
    }

    public FruitProduct buildB() {
        fruitBuilder.buildBanana().buildGrape();
        return fruitBuilder.build();
    }

    public static void main(String[] args) {
        FruitDirector fruitDirector=new FruitDirector(new FruitBuilderImpl());
        System.out.println(fruitDirector.buildA());
    }
}
