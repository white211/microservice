package com.white.orderserver.config.rabbitMq.sender;

import com.white.orderserver.config.rabbitMq.MqConfig;
//import com.white.orderserver.pojo.dto.OrdOrderDto;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Program: FirstSender
 * @Description:
 * @Author: White
 * @DateTime: 2019-05-13 16:14:20
 **/
@Component
public class FirstSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param message  消息
     */
    public void send(Object message) {
        rabbitTemplate.convertAndSend(MqConfig.EXCHANGE, MqConfig.ROUTINGKEY1,
                message);
    }



}
