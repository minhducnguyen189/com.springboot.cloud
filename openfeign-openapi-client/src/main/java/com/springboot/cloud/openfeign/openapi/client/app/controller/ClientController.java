package com.springboot.cloud.openfeign.openapi.client.app.controller;

import com.springboot.cloud.openfeign.openapi.server.app.api.ServerApi;
import com.springboot.cloud.openfeign.openapi.server.app.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientController {

    private final ServerApi serverApi;

    @RequestMapping(method = RequestMethod.GET, path = "/v1/client/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getCustomer() {
        return this.serverApi._getCustomers();
    }


}
