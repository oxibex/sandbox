package com.microservice.testconsumer.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@Configuration
public class TopicConfiguration {

    @KafkaListener(topics = "test-topic", groupId = "test-group")
    public void testListener(String message) {
        log.info("Message received: {}", message);
    }

}
