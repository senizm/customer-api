package com.example.customerapi.configuration;

import com.example.customerapi.persistence.repository.CustomerRepository;
import com.example.customerapi.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public CustomerService customerService(CustomerRepository customerRepository, ObjectMapper objectMapper) {
        return new CustomerService(customerRepository, objectMapper);
    }
}
