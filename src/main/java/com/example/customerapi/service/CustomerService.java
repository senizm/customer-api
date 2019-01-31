package com.example.customerapi.service;

import com.example.customerapi.domain.customer.create.CreateCustomerRequest;
import com.example.customerapi.domain.customer.mapper.CustomerMapper;
import com.example.customerapi.domain.customer.update.UpdateCustomerRequest;
import com.example.customerapi.exception.CustomerNotFoundException;
import com.example.customerapi.persistence.model.Customer;
import com.example.customerapi.persistence.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ObjectMapper objectMapper;
    private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(String customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(CustomerNotFoundException::new);
    }

    public Customer createCustomer(CreateCustomerRequest createCustomerRequest) {
        final Customer customer = customerMapper.createCustomerRequestToCustomer(createCustomerRequest);
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(UpdateCustomerRequest updateCustomerRequest) {
        final Optional<Customer> customerToBeUpdated = customerRepository.findById(updateCustomerRequest.getId());

        if (customerToBeUpdated.isEmpty()) {
            throw new CustomerNotFoundException();
        }

        try {
            final String updateCustomerRequestString = objectMapper.writeValueAsString(updateCustomerRequest);
            final Customer updatedCustemer = objectMapper.readerForUpdating(customerToBeUpdated.get()).readValue(updateCustomerRequestString);
            return customerRepository.save(updatedCustemer);
        } catch (IOException ex) {
            throw new CustomerNotFoundException();
        }
    }

    public void deleteCustomerById(String customerId) {
        customerRepository.deleteById(customerId);
    }
}
