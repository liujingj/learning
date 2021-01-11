package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/7
 */
public class BossClient {
    public static void main(String[] args) {

        //发布命令
        ReportWorkCommand reportWorkCommand = new ReportWorkCommand();
        //秘书接收命令
        MishuInvoker mishuInvoker = new MishuInvoker();
        mishuInvoker.setCommand(reportWorkCommand);
        //秘书执行命令
        mishuInvoker.actionCommand();
    }
}
