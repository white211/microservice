package com.white.orderserver.config.rabbitMq.mqcallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @Program: MsgSendConfirmCallBack
 * @Description:
 * @Author: White
 * @DateTime: 2019-05-13 16:00:28
 **/

public class MsgSendConfirmCallBack implements RabbitTemplate.ConfirmCallback{

    private static final Logger logger = LoggerFactory.getLogger(MsgSendConfirmCallBack.class);

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        logger.info("MsgSendConfirmCallBack  , 回调id{}:", correlationData);
        if (ack) {
            logger.info("消息消费成功");
        } else {
            logger.info("消息消费失败:{},重新发送", cause);
        }
    }

}
