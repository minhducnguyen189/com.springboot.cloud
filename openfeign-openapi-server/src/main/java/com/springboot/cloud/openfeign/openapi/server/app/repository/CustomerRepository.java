package com.springboot.cloud.openfeign.openapi.server.app.repository;

import com.springboot.cloud.openfeign.openapi.server.app.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {



}
