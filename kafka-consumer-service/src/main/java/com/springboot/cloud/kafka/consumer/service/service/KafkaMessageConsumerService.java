package com.springboot.cloud.kafka.consumer.service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.cloud.kafka.consumer.service.consumer.KafkaMessageHandler;
import com.springboot.cloud.kafka.consumer.service.model.KafkaMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KafkaMessageConsumerService implements KafkaMessageHandler {

    private final ObjectMapper objectMapper;

    @Override
    public void onMessageReceived(KafkaMessageDto kafkaMessageDto) {
        try {
            log.info("Kafka Message Received: " + this.objectMapper.writeValueAsString(kafkaMessageDto));
        } catch (JsonProcessingException ex) {
            throw new RuntimeException("Invalid Kafka message received");
        }
    }
}
