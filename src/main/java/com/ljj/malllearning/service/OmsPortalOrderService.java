package com.ljj.malllearning.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author ljj
 * @date 2020/10/12
 */
public interface OmsPortalOrderService {

    /**
     * 生成订单
     */
    @Transactional
    void generateOrder();

    /**
     * 取消超时订单
     */
    @Transactional
    void cancelOrder();
}
