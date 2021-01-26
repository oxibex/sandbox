package com.example.rest;

import com.example.dto.MessageDto;
import com.example.dto.MessageRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author Nikolay Chechenko.
 * @since 25.01.2021
 */
@Slf4j
@RequestMapping(path = "msg")
@RestController
public class MessageRest {

    public static final String TOPIC_MESSAGE = "msg";
    @Autowired
    private KafkaTemplate<String, MessageDto> kafkaTemplate;

    @PostMapping
    public void sendMessage(@RequestBody MessageRequestDto message) {
        MessageDto messageDto = new MessageDto("user", message.getMessage());
        ListenableFuture<SendResult<String, MessageDto>> future = kafkaTemplate.send(TOPIC_MESSAGE, message.getId(), messageDto);
        future.addCallback(s -> log.info(String.valueOf(s)), f -> log.info(String.valueOf(f)));
        kafkaTemplate.flush();
    }

}
