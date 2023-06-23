package com.springboot.cloud.kafka.consumer.service.config;

import com.springboot.cloud.kafka.consumer.service.model.KafkaMessageDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.mapping.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.mapping.Jackson2JavaTypeMapper;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KafkaConsumerConfig {

    private final KafkaConsumerConfigProperties kafkaConsumerConfigProperties;

    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        Map<String, Object> kafkaConsumerConfigs = new HashMap<>();
        kafkaConsumerConfigs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConsumerConfigProperties.getBootstrapServer());
        kafkaConsumerConfigs.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaConsumerConfigProperties.getGroupId());
        kafkaConsumerConfigs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        kafkaConsumerConfigs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        kafkaConsumerConfigs.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, StringDeserializer.class);
        kafkaConsumerConfigs.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class);
        kafkaConsumerConfigs.put(JsonDeserializer.TYPE_MAPPINGS, "kafkaMessageDto:com.springboot.cloud.kafka.consumer.service.model.KafkaMessageDto");
        kafkaConsumerConfigs.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        kafkaConsumerConfigs.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, "30000000");
        if (kafkaConsumerConfigProperties.isSslSecurityEnabled()) {
            kafkaConsumerConfigs.put("security.protocol", "SSL");
            kafkaConsumerConfigs.put("ssl.truststore.location", kafkaConsumerConfigProperties.getSslTrustStoreLocation());
            kafkaConsumerConfigs.put("ssl.truststore.password", kafkaConsumerConfigProperties.getSslTrustStorePassword());
            kafkaConsumerConfigs.put("ssl.key.password", kafkaConsumerConfigProperties.getSslPassword());
            kafkaConsumerConfigs.put("ssl.keystore.password", kafkaConsumerConfigProperties.getSslKeyStorePassword());
            kafkaConsumerConfigs.put("ssl.keystore.location", kafkaConsumerConfigProperties.getSslKeyStoreLocation());
        }
        return new DefaultKafkaConsumerFactory<>(kafkaConsumerConfigs);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
