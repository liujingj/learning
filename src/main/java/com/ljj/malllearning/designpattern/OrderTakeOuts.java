package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/13
 */
public abstract class OrderTakeOuts {

    public void order() {
        openApp();
        orderSomething();
        pay();
    }

    public void openApp() {
        System.out.println("打开外卖app");
    }

    public abstract void orderSomething();

    public void pay() {
        System.out.println("支付");
    }
}
