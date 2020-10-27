package com.ljj.malllearning.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 取消订单消息接收者
 *
 * @author ljj
 * @date 2020/10/12
 */
@Component
@RabbitListener(queues = "mall.order.cancel")
public class OrderCancelReceiver {

    @RabbitHandler
    public void handle(Long orderId) {
        //取消订单逻辑
    }
}
