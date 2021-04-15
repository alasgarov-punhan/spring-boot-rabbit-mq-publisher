package com.codelearning.springrabbitmq.controller;

import com.codelearning.springrabbitmq.model.Message;
import com.codelearning.springrabbitmq.service.QueueReceiver;
import com.codelearning.springrabbitmq.service.QueueSender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publisher")
public class MessageController {
    private static final Logger logger = LogManager.getLogger(MessageController.class);

    private final QueueSender queueSender;

    public MessageController(QueueSender queueSender) {
        this.queueSender = queueSender;
    }

    @PostMapping("/directExchange")
    public ResponseEntity<String> sendMessageToQueueWithDirectExchange(@RequestBody Message message){
        logger.info("sendMessageToQueue routingKey {} with message {}", message.getRoutingKey() , message.getMessageBody());
        return queueSender.sendNotificationToQueue(message);
    }

}
