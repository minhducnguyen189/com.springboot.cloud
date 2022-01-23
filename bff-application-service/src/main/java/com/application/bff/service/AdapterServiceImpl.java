package com.application.bff.service;

import com.application.bff.adapters.AdapterServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdapterServiceImpl implements AdapterService{

    @Autowired
    private AdapterServiceApi adapterServiceApi;

    @Override
    public String getPostById(String id) {
        return adapterServiceApi.getPostById(id);
    }
}
