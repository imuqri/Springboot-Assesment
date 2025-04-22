package com.accenturebe.onlinefooddelivery.mapper;

import com.accenturebe.onlinefooddelivery.dto.CustomerDTO;
import com.accenturebe.onlinefooddelivery.entity.Customer;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface CustomerMapper {
    Customer toCustomer (CustomerDTO customerDTO);
    CustomerDTO toCustomerDTO (Customer customer);

//  List<CustomerDTO> toCustomerDTOs (List<Customer> customers);
}
