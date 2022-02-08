package com.springboot.cloud.openfeign.openapi.server.app.controller;

import com.springboot.cloud.openfeign.openapi.server.app.api.V1Api;
import com.springboot.cloud.openfeign.openapi.server.app.model.Customer;
import com.springboot.cloud.openfeign.openapi.server.app.model.CustomerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ServerController implements V1Api {

    @Override
    public ResponseEntity<UUID> createCustomer(CustomerRequest customerRequest) {
        return new ResponseEntity<>(UUID.randomUUID(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Customer>> getCustomers() {
        Customer customer = new Customer();
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


}
