package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/12
 */
public class StateClient {
    public static void main(String[] args) {
        Context context = new Context();
        context.setOrderState(new WaitDeliverState());
        context.returns();
        context.evaluate();
    }
}
