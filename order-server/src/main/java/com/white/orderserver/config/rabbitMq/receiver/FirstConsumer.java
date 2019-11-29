package com.white.orderserver.config.rabbitMq.receiver;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(FirstConsumer.class);

    @RabbitListener(queues = {"order-queue"}, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage(String message) throws Exception {
        // 处理消息
        logger.info(">>>>>>>>>消费者<<<<<<<<<<  FirstConsumer {} handleMessage :",message);
    }

}
