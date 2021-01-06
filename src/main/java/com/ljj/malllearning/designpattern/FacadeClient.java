package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/6
 */
public class FacadeClient {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.cook();
    }
}
