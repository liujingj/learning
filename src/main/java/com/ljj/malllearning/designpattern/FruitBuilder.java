package com.ljj.malllearning.designpattern;

/**
 * 构建水果套餐的步骤
 *
 * @author ljj
 * @date 2021/1/3
 */
public abstract class FruitBuilder {
    FruitProduct fruitProduct = new FruitProduct();

    abstract FruitBuilder buildApple();

    abstract FruitBuilder buildBanana();

    abstract FruitBuilder buildOrange();

    abstract FruitBuilder buildStrawberry();

    abstract FruitBuilder buildGrape();

    FruitProduct build() {
        return fruitProduct;
    }
}
