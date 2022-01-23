package com.application.adapter.configs;

import com.application.adapter.models.env.PageEnv;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProperties {

    @Bean
    @ConfigurationProperties(prefix = "post.page")
    public PageEnv pageEnv() {
        return new PageEnv();
    }

}
