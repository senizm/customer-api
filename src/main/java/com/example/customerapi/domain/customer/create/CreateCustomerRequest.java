package com.example.customerapi.domain.customer.create;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateCustomerRequest {

    private String name;
    private String tckn;
}
