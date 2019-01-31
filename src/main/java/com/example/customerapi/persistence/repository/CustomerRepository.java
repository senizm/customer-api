package com.example.customerapi.persistence.repository;

import com.example.customerapi.persistence.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
