/*
package com.codelearning.springrabbitmq.listener;

import com.codelearning.springrabbitmq.model.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @RabbitListener(queues = "${queue.name}")
    public void handleMessage(Message notification) {
        System.out.println("Message received");
        System.out.println(notification);
    }
}
*/
