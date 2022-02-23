package com.springboot.cloud.bff.openfeign.lib.service;

import com.springboot.cloud.bff.openfeign.lib.api.AdapterServiceApi;
import com.springboot.cloud.openfeign.lib.service.FeignClientAdapterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private FeignClientAdapterBuilder<AdapterServiceApi> feignClientAdapterBuilder;

    public String getPostById(String id) {
        AdapterServiceApi adapterServiceApi = this.feignClientAdapterBuilder
                        .feignClientAdapterConfig("adapter.service.url", "vn", AdapterServiceApi.class);
        return adapterServiceApi.getPostById(id);
    }

}
