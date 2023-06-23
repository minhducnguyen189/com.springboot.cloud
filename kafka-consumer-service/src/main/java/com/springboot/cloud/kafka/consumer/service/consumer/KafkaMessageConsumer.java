package com.springboot.cloud.kafka.consumer.service.consumer;

import org.springframework.kafka.annotation.KafkaListener;

@KafkaListener(topics = "${kafka.consumer.topic}", groupId = "${kafka.consumer.groupId}", containerFactory = "kafkaListenerContainerFactory")
public interface KafkaMessageConsumer {
}
