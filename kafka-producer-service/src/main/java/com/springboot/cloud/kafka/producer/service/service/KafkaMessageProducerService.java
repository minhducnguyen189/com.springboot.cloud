package com.springboot.cloud.kafka.producer.service.service;

import com.springboot.cloud.kafka.producer.service.config.KafkaProducerConfigProperties;
import com.springboot.cloud.kafka.producer.service.model.KafkaMessageDto;
import com.springboot.cloud.kafka.producer.service.producer.KafkaMessageProducerApi;
import com.springboot.cloud.kafka.producer.service.producer.KafkaMessageProducerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KafkaMessageProducerService {

    private final KafkaProducerConfigProperties kafkaProducerConfigProperties;
    private final KafkaMessageProducerApi kafkaMessageProducerApi;

    public void sendMessageToKafka(KafkaMessageDto kafkaMessageDto) {
        this.kafkaMessageProducerApi.send(this.kafkaProducerConfigProperties.getTopic(), kafkaMessageDto);
    }


}
