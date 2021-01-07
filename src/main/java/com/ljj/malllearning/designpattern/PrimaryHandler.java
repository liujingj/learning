package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/7
 */
public class PrimaryHandler extends Handler {

    @Override
    public void doHandle(Request request) {
        //处理结果 自定义处理逻辑
        boolean result = true;
        System.out.println("初级是否通过=" + result);
        //如果初级面试通过而且有下一轮面试 则进行下一轮面试
        if (result && getNextHandler() != null) {
            getNextHandler().doHandle(request);
        }
    }
}
