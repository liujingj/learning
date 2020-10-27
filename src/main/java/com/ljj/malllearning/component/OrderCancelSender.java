package com.ljj.malllearning.component;

import com.ljj.malllearning.common.QueueEnum;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 取消订单的发送者
 * @author ljj
 * @date 2020/10/12
 */
@Component
public class OrderCancelSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Long orderId, final Long delayTimes) {
        amqpTemplate.convertAndSend(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getExchange(),
                QueueEnum.QUEUE_TTL_ORDER_CANCEL.getRouteKey(),
                orderId,
                (message) -> {
                    message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
                    return message;
                });
    }
}
