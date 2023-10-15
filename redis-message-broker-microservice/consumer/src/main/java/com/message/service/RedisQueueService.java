package com.message.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Provide FIFO queue service
 * @author nchechenko
 * @since 02.09.2023
 */
@Slf4j
@Service
@AllArgsConstructor
public class RedisQueueService {

    private final RedisTemplate<String, String> redisTemplate;

    public String receiveMessage(String topic) {
        return redisTemplate.opsForList().rightPop(topic);
    }

    public void sendMessage(String topic, String message) {
        redisTemplate.opsForList().leftPush(topic, message);
    }

}
