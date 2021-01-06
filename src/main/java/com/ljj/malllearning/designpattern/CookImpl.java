package com.ljj.malllearning.designpattern;

import org.springframework.stereotype.Component;

/**
 * @author ljj
 * @date 2021/1/6
 */
public class CookImpl implements Cook {
    @Override
    public void washVegetables() {
        System.out.println("洗菜");
    }

    @Override
    public void cooking() {
        System.out.println("做饭");
    }

    @Override
    public void washDish() {
        System.out.println("洗碗");
    }
}
