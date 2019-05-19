package com.white.orderserver.config.rabbitMq.mqcallback;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @Program: MsgSendConfirmCallBack
 * @Description:
 * @Author: White
 * @DateTime: 2019-05-13 16:00:28
 **/

public class MsgSendConfirmCallBack implements RabbitTemplate.ConfirmCallback{

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("MsgSendConfirmCallBack  , 回调id:" + correlationData);
        if (ack) {
            System.out.println("消息消费成功");
        } else {
            System.out.println("消息消费失败:" + cause+"\n重新发送");
        }
    }

}
