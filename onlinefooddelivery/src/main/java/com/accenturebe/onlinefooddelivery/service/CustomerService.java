package com.accenturebe.onlinefooddelivery.service;

import com.accenturebe.onlinefooddelivery.dto.CustomerDTO;
import com.accenturebe.onlinefooddelivery.entity.Customer;
import com.accenturebe.onlinefooddelivery.mapper.CustomerMapper;
import com.accenturebe.onlinefooddelivery.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();

    }

    public CustomerDTO createCustomer(CustomerDTO request) {
        Customer customer = customerMapper.toCustomer(request);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toCustomerDTO(savedCustomer);
//        return customerMapper.toCustomerDTO((customerRepository.save(customer)));
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
