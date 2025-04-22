package com.accenturebe.onlinefooddelivery.controller;

import com.accenturebe.onlinefooddelivery.dto.CustomerDTO;
import com.accenturebe.onlinefooddelivery.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")  //  base path url
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customer) {
        CustomerDTO createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @PostMapping("delete/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok().build();
    }

}
