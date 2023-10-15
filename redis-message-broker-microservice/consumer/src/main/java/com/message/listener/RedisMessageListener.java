package com.message.listener;

import com.message.service.RedisMessageHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author nchechenko
 * @since 08.10.2023
 */
@Slf4j
public class RedisMessageListener implements MessageListener {

    @Autowired
    private RedisMessageHandler redisMessageHandler;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("Message received {} ", message);
        redisMessageHandler.handleQueue();
    }
}
