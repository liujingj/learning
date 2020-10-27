package com.ljj.malllearning.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ljj
 * @date 2020/10/12
 */
@Getter
@AllArgsConstructor
public enum QueueEnum {

    /**
     * 消息通知队列
     */
    QUEUE_ORDER_CANCEL("mall.order.direct", "mall.order.cancel", "mall.order.cancel"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_ORDER_CANCEL("mall.order.direct.ttl", "mall.order.cancel.ttl", "mall.order.cancel.ttl"),
    ;
    private String exchange;
    private String queueName;
    private String routeKey;
}
