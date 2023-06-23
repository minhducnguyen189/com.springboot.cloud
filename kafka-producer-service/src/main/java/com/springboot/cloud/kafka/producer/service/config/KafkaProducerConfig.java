package com.springboot.cloud.kafka.producer.service.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KafkaProducerConfig {

    private final KafkaProducerConfigProperties kafkaProducerConfigProperties;

    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> kafkaProducerConfigs = new HashMap<>();
        kafkaProducerConfigs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProducerConfigProperties.getBootstrapServer());
        kafkaProducerConfigs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        kafkaProducerConfigs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        kafkaProducerConfigs.put(JsonSerializer.TYPE_MAPPINGS, "kafkaMessageDto:com.springboot.cloud.kafka.producer.service.model.KafkaMessageDto");
        kafkaProducerConfigs.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, "30000000");
        if (kafkaProducerConfigProperties.isSslSecurityEnabled()) {
            kafkaProducerConfigs.put("security.protocol", "SSL");
            kafkaProducerConfigs.put("ssl.truststore.location", kafkaProducerConfigProperties.getSslTrustStoreLocation());
            kafkaProducerConfigs.put("ssl.truststore.password", kafkaProducerConfigProperties.getSslTrustStorePassword());
            kafkaProducerConfigs.put("ssl.key.password", kafkaProducerConfigProperties.getSslPassword());
            kafkaProducerConfigs.put("ssl.keystore.password", kafkaProducerConfigProperties.getSslKeyStorePassword());
            kafkaProducerConfigs.put("ssl.keystore.location", kafkaProducerConfigProperties.getSslKeyStoreLocation());
        }
        return new DefaultKafkaProducerFactory<>(kafkaProducerConfigs);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
