package com.springboot.cloud.kafka.producer.service.producer;

public interface KafkaMessageProducerApi {

    void send(String topic, Object message);

}
