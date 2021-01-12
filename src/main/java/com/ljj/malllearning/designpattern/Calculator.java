package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/11
 */
public class Calculator {

    public void calculate(String statement) {
        String[] values = statement.split(" ");
        Expression current = null;
        for (int i = 0; i < values.length; i++) {
            if ("*".equals(values[i])) {
                current = new MulSymbolExpression(current, new ElementExpression(Integer.valueOf(values[++i])));
            } else if ("/".equals(values[i])) {
                current = new DivSymbolExpression(current, new ElementExpression(Integer.valueOf(values[++i])));
            } else if ("%".equals(values[i])) {
                current = new ModSymbolExpression(current, new ElementExpression(Integer.valueOf(values[++i])));
            } else {
                current = new ElementExpression(Integer.valueOf(values[i]));
            }
        }
        System.out.println(current.interpreter());
    }
}
