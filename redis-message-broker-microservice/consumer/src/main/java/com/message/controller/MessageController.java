package com.message.controller;

import com.message.dto.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nchechenko
 * @since 30.08.2023
 */
@RestController
@RequestMapping("api/message")
public class MessageController {
    private final RedisTemplate<String, Message> redisTemplate;

    public MessageController(RedisTemplate<String, Message> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostMapping
    public void sendMessage(@RequestBody Message message) {
        redisTemplate.convertAndSend("news", message);
    }

    @GetMapping("{id}")
    public Message getMessage(@PathVariable String id) {
        Message message = redisTemplate.opsForValue().get(id);
        return message;
    }

}
