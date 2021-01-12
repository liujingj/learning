package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/11
 */
public abstract class SymbolExpression implements Expression {
    //符号左侧的元素
    protected Expression left;
    //符号右侧的元素
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
