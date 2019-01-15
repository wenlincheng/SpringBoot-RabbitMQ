package com.wenlincheng.rabbitmq.pojo;

import java.io.Serializable;

/**
 * @ClassName: EmailInfo
 * @Description: TODO
 * @Author: Cheng
 * @Date: 2019/1/12 1:14
 * @Version: 1.0.0
 */
public class EmailInfo implements Serializable {
    private static final long serialVersionUID = 9174959583878898185L;
    private String emailAddress;
    private String emailMessage;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    @Override
    public String toString() {
        return "EmailInfo{" +
                "emailAddress='" + emailAddress + '\'' +
                ", emailMessage='" + emailMessage + '\'' +
                '}';
    }
}
