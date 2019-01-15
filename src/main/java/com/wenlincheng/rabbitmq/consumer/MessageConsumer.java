package com.wenlincheng.rabbitmq.consumer;


import com.wenlincheng.rabbitmq.pojo.EmailInfo;
import com.wenlincheng.rabbitmq.util.EmailUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MessageConsummer
 * @Description: 消息消费者
 * @Author: Cheng
 * @Date: 2019/1/11 21:15
 * @Version: 1.0.0
 */
@Component
public class MessageConsumer {

    /**
     * @MethodName: handleMessage
     * @Description: 处理消息
     * @Params: [message]
     * @Return: void
     * @Author: Cheng
     * @Date: 2019/1/11 21:19
     */
    @RabbitListener(queues = {"email-queue"}, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage(EmailInfo message) throws Exception {
        // 处理消息
        System.out.println("FirstConsumer {} handleMessage :"+message.getEmailMessage());

        String[] users = {message.getEmailAddress()};

        boolean sendEmail = EmailUtils.sendEmail("Shuke回复你啦", users, null, message.getEmailMessage(), null);
        System.out.println(sendEmail);

    }

}
