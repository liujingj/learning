package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/12
 */
public class WaitEvaluateState extends AbstractOrderState {

    @Override
    public void returns() {
        //do nothing
    }

    @Override
    public void receiving() {
        //do nothing
    }

    //待评价状态只能评价
    @Override
    public void evaluate() {
        System.out.println("待评价时 进行评价");
        //修改状态为 关闭
        super.context.setOrderState(context.closeState);
    }
}
