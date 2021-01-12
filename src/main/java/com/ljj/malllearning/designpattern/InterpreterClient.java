package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/11
 */
public class InterpreterClient {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.calculate("3 % 2 * 4 / 2 % 6");
    }
}
