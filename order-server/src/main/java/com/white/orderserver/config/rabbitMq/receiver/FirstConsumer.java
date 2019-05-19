package com.white.orderserver.config.rabbitMq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Program: FirstConsumer
 * @Description:
 * @Author: White
 * @DateTime: 2019-05-13 16:12:53
 **/
@Component
public class FirstConsumer {
    @RabbitListener(queues = {"order-queue"}, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage(String message) throws Exception {
        // 处理消息
        System.out.println("FirstConsumer {} handleMessage :"+message);
    }

}
