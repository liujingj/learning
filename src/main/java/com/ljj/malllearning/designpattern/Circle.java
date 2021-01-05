package com.ljj.malllearning.designpattern;

/**
 * 圆形
 *
 * @author ljj
 * @date 2021/1/5
 */
public class Circle extends Shape {
    public Circle(Colour colour) {
        super(colour);
    }

    @Override
    public void draw() {
        colour.paint("圆形");
    }
}
