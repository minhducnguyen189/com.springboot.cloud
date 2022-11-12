package com.springboot.cloud.openfeign.web.services.configuration;

import feign.jaxb.JAXBContextFactory;
import feign.soap.SOAPDecoder;
import feign.soap.SOAPEncoder;
import org.springframework.context.annotation.Bean;

/**
 We should not put the annotation @Configuration here
 because Feign will override all other Feign clients with
 this configuration class
 */
public class FeignSOAPConfiguration {

    @Bean
    public JAXBContextFactory configJAXBContextFactory() {
        return new JAXBContextFactory.Builder()
                .withMarshallerJAXBEncoding("UTF-8")
                .withMarshallerSchemaLocation("http://api rest http://api host/schema.xsd")
                .build();
    }

    @Bean
    public SOAPDecoder feignDecoder() {
        return new SOAPDecoder(configJAXBContextFactory());
    }

    @Bean
    public SOAPEncoder feignEncoder() {
        return new SOAPEncoder(configJAXBContextFactory());
    }

}
