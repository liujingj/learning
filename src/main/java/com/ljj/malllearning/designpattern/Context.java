package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/12
 */
public class Context {
    //定义所有的状态
    public final WaitDeliverState waitDeliverState = new WaitDeliverState();
    public final WaitReceivingState waitReceivingState = new WaitReceivingState();
    public final WaitEvaluateState waitEvaluateState = new WaitEvaluateState();
    public final CloseState closeState = new CloseState();

    //定义当前的状态
    private AbstractOrderState orderState;

    public AbstractOrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(AbstractOrderState orderState) {
        this.orderState = orderState;
        //给当前状态设置context
        this.orderState.setContext(this);
    }

    //退货
    public void returns() {
        this.orderState.returns();
    }

    //收货
    public void receiving() {
        this.orderState.receiving();
    }

    //评价
    public void evaluate() {
        this.orderState.evaluate();
    }

}

