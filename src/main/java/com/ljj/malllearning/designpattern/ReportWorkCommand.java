package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/7
 */
public class ReportWorkCommand extends Command {

    @Override
    public void execute() {
        //每个命令具体实现步骤
        super.hrReceiver.reportWork();
        super.financeReceiver.reportWork();
        super.saleReceiver.reportWork();
    }
}
