package com.wenlincheng.rabbitmq.controller;

import com.wenlincheng.rabbitmq.pojo.EmailInfo;
import com.wenlincheng.rabbitmq.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName: EmailController
 * @Description: 发送邮件
 * @Author: Cheng
 * @Date: 2019/1/11 21:21
 * @Version: 1.0.0
 */
@RestController
public class EmailController {

    @Autowired
    private MessageProducer messageProducer;

    @GetMapping("/send")

    public String sendEmail(){
        String uuid = UUID.randomUUID().toString();

        EmailInfo emailInfo = new EmailInfo();
        emailInfo.setEmailAddress("1511181420@qq.com");
        emailInfo.setEmailMessage("哈哈哈");
        messageProducer.send(uuid, emailInfo);
        return uuid;
    }



}
