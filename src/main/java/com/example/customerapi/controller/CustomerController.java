package com.example.customerapi.controller;

import com.example.customerapi.domain.customer.create.CreateCustomerRequest;
import com.example.customerapi.domain.customer.update.UpdateCustomerRequest;
import com.example.customerapi.persistence.model.Customer;
import com.example.customerapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return customerService.createCustomer(createCustomerRequest);
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return customerService.updateCustomer(updateCustomerRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable String id) {
        customerService.deleteCustomerById(id);
    }
}
