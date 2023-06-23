package com.springboot.cloud.kafka.consumer.service.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KafkaTopicConfig {

    private final KafkaConsumerConfigProperties kafkaConsumerConfigProperties;

    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConsumerConfigProperties.getBootstrapServer());
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic applicationTopic() {
        String applicationTopicName = this.kafkaConsumerConfigProperties.getTopic();
        return TopicBuilder.name(applicationTopicName).partitions(1).replicas(1).build();
    }

}
