package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/12
 */
public abstract class AbstractOrderState {

    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    //退货
    public abstract void returns();

    //收货
    public abstract void receiving();

    //评价
    public abstract void evaluate();

}
