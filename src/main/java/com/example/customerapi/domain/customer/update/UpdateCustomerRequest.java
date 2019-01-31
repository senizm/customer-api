package com.example.customerapi.domain.customer.update;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateCustomerRequest {

    private String id;
    private String name;
}
