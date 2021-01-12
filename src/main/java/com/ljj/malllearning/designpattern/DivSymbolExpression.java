package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/11
 */
public class DivSymbolExpression extends SymbolExpression {
    public DivSymbolExpression(Expression left, Expression right) {
        super(left, right);
    }

    //除法解析
    @Override
    public int interpreter() {
        return left.interpreter() / right.interpreter();
    }
}
