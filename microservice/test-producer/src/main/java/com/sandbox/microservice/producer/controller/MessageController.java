package com.sandbox.microservice.producer.controller;

import com.sandbox.microservice.producer.configuration.KafkaTopicConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/api/message")
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void sendMessage(@RequestBody String message) {
        CompletableFuture<SendResult<String, String>> send = this.kafkaTemplate.send(KafkaTopicConfig.TEST_TOPIC, message);
        send.whenComplete((stringStringSendResult, throwable) -> {
            if (throwable == null) {
                log.info("Message has been sent successfully");
            } else {
                log.error("Error while sending message {} ", throwable.getMessage());
            }
        });
    }

}
