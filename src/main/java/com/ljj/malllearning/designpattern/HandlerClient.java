package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/7
 */
public class HandlerClient {
    public static void main(String[] args) {
        //设置每一个职责链的处理器以及下一个处理器
        PrimaryHandler primaryHandler = new PrimaryHandler();
        MiddleHandler middleHandler = new MiddleHandler();
        HighHandler highHandler = new HighHandler();
        primaryHandler.setNextHandler(middleHandler);
        middleHandler.setNextHandler(highHandler);
        //开始处理
        primaryHandler.doHandle(new Request());
    }
}
