package com.springboot.cloud.kafka.producer.service.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KafkaMessageProducerImpl implements KafkaMessageProducerApi {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void send(String topic, Object message) {
        this.kafkaTemplate.send(topic, message);
    }

}
