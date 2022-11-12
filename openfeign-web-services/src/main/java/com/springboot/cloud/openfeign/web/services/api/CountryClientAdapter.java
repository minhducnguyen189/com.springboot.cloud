package com.springboot.cloud.openfeign.web.services.api;

import com.springboot.cloud.openfeign.web.services.configuration.FeignSOAPConfiguration;
import com.springboot.cloud.openfeign.web.services.models.gen.CountryName;
import com.springboot.cloud.openfeign.web.services.models.gen.CountryNameResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 this @FeignClient includes 3 attributes:
 name of @FeignClient, url of SOAP service, configuration class for this FeignClient
 */
@FeignClient(name = "soap.client.example",
        url = "${country.client.soap.url}",
        configuration = FeignSOAPConfiguration.class)
public interface CountryClientAdapter {

    /**
     @RequestBody (CountryName) and CountryNameResponse  are the Object classes
     with format xml that was generated from the wsdl file.
     So the attribute consumes and produces must be "text/xml"
     */
    @PostMapping(value = "", consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE)
    CountryNameResponse get(@RequestBody CountryName countryName);

}
