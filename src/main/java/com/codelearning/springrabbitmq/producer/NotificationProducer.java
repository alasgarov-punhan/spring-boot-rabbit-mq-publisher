/*
package com.codelearning.springrabbitmq.producer;

import com.codelearning.springrabbitmq.model.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {

    @Value("${routing.name}")
    private String routingName;

    @Value("${exchange.name}")
    private String exchangeName;


    // PostConstruct yeni bu obyekt dogru bir sekilde initialize oldugdan sonra gondersin
    @PostConstruct
    public void init() {
        Message notification = new Message();
        notification.setMessageId(UUID.randomUUID().toString());
        notification.setMessageBody("Haydi Kodlayalim platformuna hosgeldiniz");
        sendToQueue(notification);
    }

    //RabbitTemplate bu bizim rabbit mq nin connectin obyketi kimi bunun uzerinden getirik servere
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToQueue(Message notification) {
        System.out.println("Message Sent ID : " + notification.getMessageBody());
        rabbitTemplate.convertAndSend(exchangeName, routingName, notification);
    }
}
*/
