package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/5
 */
public class BridgeClient {
    public static void main(String[] args) {
        Circle circle = new Circle(new Red());
        circle.draw();
    }
}
