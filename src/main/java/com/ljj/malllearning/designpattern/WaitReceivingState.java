package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/12
 */
public class WaitReceivingState extends AbstractOrderState {

    //待收货状态 可以退货
    @Override
    public void returns() {
        System.out.println("待收货时 进行退货");
        //修改状态为 待评价
        super.context.setOrderState(context.waitEvaluateState);
    }

    //待收货状态 可以收货
    @Override
    public void receiving() {
        System.out.println("待收货时 进行收货");
        //修改状态为 待评价
        super.context.setOrderState(context.waitEvaluateState);
    }

    @Override
    public void evaluate() {
        //do nothing
    }
}
