package com.codelearning.springrabbitmq.model;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    private String routingKey;
    private String messageId;
    private String by;
    private String messageBody;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    @Override
    public String toString() {
        return "Message{" +
                "routingKey='" + routingKey + '\'' +
                ", messageId='" + messageId + '\'' +
                ", by='" + by + '\'' +
                ", messageBody='" + messageBody + '\'' +
                '}';
    }
}