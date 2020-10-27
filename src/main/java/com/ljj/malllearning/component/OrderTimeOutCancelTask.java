package com.ljj.malllearning.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 订单超时后的定时取消订单
 * @author ljj
 * @date 2020/9/29
 */
@Slf4j
@Component
public class OrderTimeOutCancelTask {

    /**
     * 每隔10分钟扫描一次
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimoutOrder(){
        //取消逻辑
    }
}
