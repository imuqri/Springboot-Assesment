package com.accenturebe.onlinefooddelivery.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {


    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Phone Number is required")
    private String phoneNumber;

    @Email(message = "Email is required")
    private String email;
}
