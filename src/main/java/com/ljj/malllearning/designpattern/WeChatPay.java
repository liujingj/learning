package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/13
 */
public class WeChatPay implements Pay {
    @Override
    public void pay() {
        System.out.println("微信支付");
    }
}
