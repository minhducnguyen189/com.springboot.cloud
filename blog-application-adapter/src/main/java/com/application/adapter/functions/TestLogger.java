package com.application.adapter.functions;

import com.application.adapter.exception.ApiException;
import com.application.adapter.models.request.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Component("TestLogger")
public class TestLogger implements BiConsumer<String, Post> {

    private final Logger LOGGER = LoggerFactory.getLogger(TestLogger.class);


    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void accept(String s, Post post) {
        LOGGER.info("input id {}", s);
        try {
            LOGGER.info("input body {}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(post));
        } catch (JsonProcessingException ex) {
            throw new ApiException("can not parse object to String", ex);
        }
    }
}
