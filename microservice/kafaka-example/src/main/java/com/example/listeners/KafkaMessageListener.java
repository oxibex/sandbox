package com.example.listeners;

import com.example.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.example.rest.MessageRest.TOPIC_MESSAGE;

/**
 * @author Nikolay Chechenko.
 * @since 25.01.2021
 */
@Slf4j
@Component
public class KafkaMessageListener {

    @KafkaListener(topics = {TOPIC_MESSAGE})
    public void messageListener(ConsumerRecord<String, MessageDto> record) {
        MessageDto value = record.value();
        log.info("Partition {} | Key {} | Value {}",
                record.partition(), record.key(), value);
    }

}
