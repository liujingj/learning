package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/13
 */
public class BankCardPay implements Pay {
    @Override
    public void pay() {
        System.out.println("银行卡支付");
    }
}
