package com.springboot.cloud.bff.openfeign.lib.service;

import com.google.gson.Gson;
import com.springboot.cloud.bff.openfeign.lib.api.AdapterServiceApi;
import com.springboot.cloud.openfeign.lib.service.FeignClientAdapterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private FeignClientAdapterBuilder<AdapterServiceApi> feignClientAdapterBuilder;

    public String getPostById(String countryCode, String id) {
        AdapterServiceApi adapterServiceApi = this.feignClientAdapterBuilder
                        .feignClientAdapterConfig("adapter.service.url", countryCode, AdapterServiceApi.class);
        return new Gson().toJson(adapterServiceApi.getPostById(id));
    }

}
