package com.springboot.cloud.openfeign.web.services.service;

import com.springboot.cloud.openfeign.web.services.api.CountryClientAdapter;
import com.springboot.cloud.openfeign.web.services.models.gen.CountryName;
import com.springboot.cloud.openfeign.web.services.models.gen.CountryNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryCodeHandler {

    @Autowired
    private CountryClientAdapter countryClientAdapter;

    public CountryNameResponse getCountryName(String countryISO) {
        CountryName countryName = new CountryName();
        countryName.setSCountryISOCode(countryISO);
        return countryClientAdapter.get(countryName);
    }

}
