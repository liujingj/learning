package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/7
 */
public class DishWashingMachine implements WashDish {

    private Me me;

    public DishWashingMachine(Me me) {
        this.me = me;
    }

    @Override
    public void washDish() {
        me.washDish();
        System.out.println("机器人洗的很干净");
    }
}
