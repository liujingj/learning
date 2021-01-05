package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/5
 */
public class Red implements Colour {
    @Override
    public void paint(String shape) {
        System.out.println("红色的" + shape);
    }
}
