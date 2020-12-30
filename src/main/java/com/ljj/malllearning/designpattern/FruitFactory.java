package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2020/12/30
 */
public class FruitFactory {
    public static Fruit getFruit(String type) {
        if ("apple".equals(type)) {
            return new Apple();
        }
        if ("orange".equals(type)) {
            return new Orange();
        }
        return null;
    }
}
