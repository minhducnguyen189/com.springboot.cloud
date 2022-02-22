package com.springboot.cloud.openfeign.lib.service;

import feign.Feign;
import feign.Logger;
import feign.codec.ErrorDecoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class FeignClientAdapterBuilder<T> {

    @Autowired
    private Environment env;

    public T feignClientAdapterConfig(String prefix, String code, Class<T> tClass) {
        return Feign.builder()
                .client(new OkHttpClient()) //configure client
                .decoder(new GsonDecoder()) //configure decoder
                .encoder(new GsonEncoder()) //configure encoder
                .errorDecoder(new ErrorDecoder.Default())   //confiure errorDecoder
                .logger(new Slf4jLogger(tClass))     //configure logger
                .logLevel(Logger.Level.FULL)        //configure logLevel
                //configure target url
                .target(tClass, env.getProperty(prefix.concat(".").concat(code)));
    }

}
