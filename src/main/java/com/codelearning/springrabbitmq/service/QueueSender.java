package com.codelearning.springrabbitmq.service;

import com.codelearning.springrabbitmq.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface QueueSender {
    ResponseEntity<String> sendNotificationToQueue(Message messageDto);
}
