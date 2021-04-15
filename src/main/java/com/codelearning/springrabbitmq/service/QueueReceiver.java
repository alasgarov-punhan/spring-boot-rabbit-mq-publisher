package com.codelearning.springrabbitmq.service;

import com.codelearning.springrabbitmq.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface QueueReceiver {
    ResponseEntity<Message> messageGetFromQueue(String message);
}
