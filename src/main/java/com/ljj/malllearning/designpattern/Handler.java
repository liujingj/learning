package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/7
 */
public abstract class Handler {

    //下一个处理器
    private Handler nextHandler;

    //每一个处理器的处理逻辑
    public abstract void doHandle(Request request);

    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    public Handler getNextHandler() {
        return nextHandler;
    }

}
