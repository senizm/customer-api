package com.example.customerapi.domain.customer.mapper;

import com.example.customerapi.domain.customer.create.CreateCustomerRequest;
import com.example.customerapi.domain.customer.update.UpdateCustomerRequest;
import com.example.customerapi.persistence.model.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer createCustomerRequestToCustomer(CreateCustomerRequest createCustomerRequest);
    Customer updateCustomerRequestToCustomer(UpdateCustomerRequest updateCustomerRequest);
}