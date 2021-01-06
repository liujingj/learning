package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/6
 */
public abstract class Decorate implements Cake {
    private Cake cake;

    public Decorate(Cake cake){
        this.cake=cake;
    }

    @Override
    public void makeCake() {
        cake.makeCake();
    }

}
