package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/11
 */
public class ModSymbolExpression extends SymbolExpression {
    public ModSymbolExpression(Expression left, Expression right) {
        super(left, right);
    }

    //取模解析
    @Override
    public int interpreter() {
        return left.interpreter() % right.interpreter();
    }
}
