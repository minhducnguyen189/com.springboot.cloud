package com.springboot.cloud.sleuth.log4j2.kafka.zipkin.eureka.server.config;

import brave.baggage.BaggageFields;
import brave.baggage.CorrelationScopeConfig;
import brave.baggage.CorrelationScopeCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SleuthConfig {

    @Bean
    CorrelationScopeCustomizer addSampled() {
        return b -> b.add(CorrelationScopeConfig.SingleCorrelationField.create(BaggageFields.SAMPLED));
    }

    @Bean
    CorrelationScopeCustomizer addParentId() {
        return b -> b.add(CorrelationScopeConfig.SingleCorrelationField.create(BaggageFields.PARENT_ID));
    }

}
