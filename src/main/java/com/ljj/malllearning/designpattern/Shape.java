package com.ljj.malllearning.designpattern;

/**
 * 形状-对象抽象类
 *
 * @author ljj
 * @date 2021/1/5
 */
public abstract class Shape {
    Colour colour;

    public Shape(Colour colour) {
        this.colour = colour;
    }

    public abstract void draw();
}
