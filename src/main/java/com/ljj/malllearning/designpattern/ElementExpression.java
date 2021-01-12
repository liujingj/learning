package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/11
 */
public class ElementExpression implements Expression {
    private int value;

    public ElementExpression(int value) {
        this.value = value;
    }

    /**
     * 元素解析 返回元素的值
     */
    @Override
    public int interpreter() {
        return this.value;
    }
}
