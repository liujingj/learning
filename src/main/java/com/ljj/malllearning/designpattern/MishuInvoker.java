package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/7
 */
public class MishuInvoker {

    private Command command;

    //接收命令
    public void setCommand(Command command) {
        this.command = command;
    }

    //执行命令
    public void actionCommand() {
        this.command.execute();
    }
}
