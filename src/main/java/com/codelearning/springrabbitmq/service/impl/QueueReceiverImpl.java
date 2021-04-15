package com.codelearning.springrabbitmq.service.impl;

import com.codelearning.springrabbitmq.controller.MessageController;
import com.codelearning.springrabbitmq.model.Message;
import com.codelearning.springrabbitmq.service.QueueReceiver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class QueueReceiverImpl implements QueueReceiver {
    private static final Logger logger = LogManager.getLogger(QueueReceiverImpl.class);

//    @RabbitListener(queues = "${queue.name}")
    @Override
    public ResponseEntity<Message> messageGetFromQueue(String message) {
        logger.info("Message Recived {}", message);
        return null;
    }
}
