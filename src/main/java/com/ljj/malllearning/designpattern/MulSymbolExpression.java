package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/11
 */
public class MulSymbolExpression extends SymbolExpression {
    public MulSymbolExpression(Expression left, Expression right) {
        super(left, right);
    }

    //乘法解析
    @Override
    public int interpreter() {
        return left.interpreter() * right.interpreter();
    }
}
