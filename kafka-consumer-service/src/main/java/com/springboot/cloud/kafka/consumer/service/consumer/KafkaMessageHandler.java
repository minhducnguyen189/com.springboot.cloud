package com.springboot.cloud.kafka.consumer.service.consumer;

import com.springboot.cloud.kafka.consumer.service.model.KafkaMessageDto;
import org.springframework.kafka.annotation.KafkaHandler;

public interface KafkaMessageHandler extends KafkaMessageConsumer {

    @KafkaHandler
    void onMessageReceived(KafkaMessageDto kafkaMessageDto);

}
