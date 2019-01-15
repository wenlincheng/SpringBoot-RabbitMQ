package com.wenlincheng.rabbitmq.producer;

import com.wenlincheng.rabbitmq.config.RabbitMqConfig;
import com.wenlincheng.rabbitmq.pojo.EmailInfo;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MessageProducter
 * @Description: 消息生产者
 * @Author: Cheng
 * @Date: 2019/1/11 21:16
 * @Version: 1.0.0
 */
@Component
public class MessageProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * @MethodName: send
     * @Description: 发送消息
     * @Params: [uuid, message]
     * @Return: void
     * @Author: Cheng
     * @Date: 2019/1/11 21:19
     */
    public void send(String uuid, EmailInfo emailInfo) {

        CorrelationData correlationId = new CorrelationData(uuid);

        // 发送给 队列 EMAILKEY
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.EMAILKEY,
                emailInfo, correlationId);
    }

}
