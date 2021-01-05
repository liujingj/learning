package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/3
 */
public class FruitBuilderImpl extends FruitBuilder {
    @Override
    public FruitBuilder buildApple() {
        fruitProduct.setApple("apple");
        return this;
    }
    @Override
    public FruitBuilder buildBanana() {
        fruitProduct.setBanana("banana");
        return this;
    }
    @Override
    public FruitBuilder buildOrange() {
        fruitProduct.setOrange("orange");
        return this;
    }
    @Override
    public FruitBuilder buildStrawberry() {
        fruitProduct.setStrawberry("strawberry");
        return this;
    }
    @Override
    public FruitBuilder buildGrape() {
        fruitProduct.setGrape("grape");
        return this;
    }
}
