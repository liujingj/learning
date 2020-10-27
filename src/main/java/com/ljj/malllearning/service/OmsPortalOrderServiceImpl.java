package com.ljj.malllearning.service;

import com.ljj.malllearning.component.OrderCancelSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ljj
 * @date 2020/10/12
 */
@Component
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {

    @Autowired
    OrderCancelSender orderCancelSender;

    @Override
    public void generateOrder() {
        //生成订单  然后生成一条延迟消息
        orderCancelSender.sendMessage(1L, 15 * 60L);
    }

    @Override
    public void cancelOrder() {
        //订单超时后 取消订单逻辑
    }
}
