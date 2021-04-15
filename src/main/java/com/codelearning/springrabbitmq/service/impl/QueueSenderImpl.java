package com.codelearning.springrabbitmq.service.impl;

import static com.codelearning.springrabbitmq.util.Constants.EXCHANGE;
import static com.codelearning.springrabbitmq.util.Constants.ROUTING_KEY;
import com.codelearning.springrabbitmq.model.Message;
import com.codelearning.springrabbitmq.service.QueueSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QueueSenderImpl implements QueueSender {

    private static final Logger logger = LogManager.getLogger(QueueSenderImpl.class);
    private final RabbitTemplate rabbitTemplate;
    public QueueSenderImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public ResponseEntity<String> sendNotificationToQueue(Message messageDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> messageMap = new HashMap<>();
        messageMap.put("messageDto", messageDto);
        try {
            rabbitTemplate.convertAndSend(EXCHANGE.get(),messageDto.getRoutingKey(), objectMapper.writeValueAsString(messageMap));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Message wast successfully sent", HttpStatus.OK);
    }
}
