package com.message.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.message.dto.Message;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author nchechenko
 * @since 08.10.2023
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class RedisMessageHandler {

    private final ChannelTopic topic;
    private final RedisQueueService redisQueueService;
    private final ObjectMapper objectMapper;
    private final MeterRegistry meterRegistry;
    private Counter counter = null;

    @PostConstruct
    public void init(){
        counter = meterRegistry.counter("message.handled");
        handleQueue();
    }
    public void handleQueue() {
        boolean notEmpty;
        do {
            notEmpty = handleMessage();
        }while (notEmpty);
    }

    private boolean handleMessage() {
        String message = redisQueueService.receiveMessage(topic.getTopic());
        if(message != null) {
            try {
                Message messageInstance = objectMapper.reader().readValue(message, Message.class);
                counter.increment();
                log.info("Message has been handled {} ", messageInstance.toString());
            } catch (IOException e) {
                log.error("Error while mapping message");
            }

            return true;
        }
        return false;
    }


}
