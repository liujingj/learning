package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2020/12/30
 */
public class Person {

    public static void main(String[] args) {
        Fruit fruit = FruitFactory.getFruit("apple");
        System.out.println(fruit.name());

        AppleFactory appleFactory=new AppleFactory();
        appleFactory.getFruit();


    }
}
