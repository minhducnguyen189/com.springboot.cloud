package com.springboot.cloud.kafka.consumer.service.service;

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

    @Override
    public void onMessageReceived(KafkaMessageDto kafkaMessageDto) {
        log.info("Kafka Message Received: " + kafkaMessageDto.getMessage());
    }

}
