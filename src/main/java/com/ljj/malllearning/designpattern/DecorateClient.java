package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/6
 */
public class DecorateClient {

    public static void main(String[] args) {
        Cake cake = new CakeImpl();
        cake = new MilkDecorate(cake);
        cake = new ChocolateDecorate(cake);
        cake = new FruitDecorate(cake);
        cake.makeCake();
    }
}
