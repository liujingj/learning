package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/12
 */
//待发货状态
public class WaitDeliverState extends AbstractOrderState {

    //退货
    @Override
    public void returns() {
        System.out.println("待发货时 进行退货");
        //修改状态为 待评价
        super.context.setOrderState(context.waitEvaluateState);
    }

    @Override
    public void receiving() {
        //do nothing
    }

    @Override
    public void evaluate() {
        //do nothing
    }
}

