package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/11
 */
public class Mediator extends AbstractMediator {

    @Override
    public void execute() {
        //出租逻辑放在中介者
        if (landLord.getPrice() <= tenant.getPrice()) {
            System.out.println("房子可以出租");
        } else {
            System.out.println("房子不能出租");
        }
    }

}
