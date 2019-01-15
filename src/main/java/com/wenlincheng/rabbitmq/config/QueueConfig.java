package com.wenlincheng.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: QueueConfig
 * @Description: 队列配置 可以配置多个
 * @Author: Cheng
 * @Date: 2019/1/11 21:05
 * @Version: 1.0.0
 */
@Configuration
public class QueueConfig {
    /**
     * @MethodName: emailQueue
     * @Description: 邮件消息队列配置
     * @Params: []
     * @Return: org.springframework.amqp.core.Queue
     * @Author: Cheng
     * @Date: 2019/1/11 23:59
     */
    @Bean
    public Queue emailQueue() {
        /*
         durable="true" 持久化 rabbitmq 重启的时候不需要创建新的队列
         auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
         exclusive  表示该消息队列是否只在当前connection生效,默认是false
         */
        return new Queue("email-queue", true, false, false);
    }


}
