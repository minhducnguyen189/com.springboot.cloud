package com.springboot.cloud.kafka.consumer.service.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "kafka.consumer")
public class KafkaConsumerConfigProperties {

    private String bootstrapServer;
    private String groupId;
    private String topic;
    private boolean sslSecurityEnabled;
    private String sslPassword;
    private String sslTrustStorePassword;
    private String sslTrustStoreLocation;
    private String sslKeyStorePassword;
    private String sslKeyStoreLocation;

}
