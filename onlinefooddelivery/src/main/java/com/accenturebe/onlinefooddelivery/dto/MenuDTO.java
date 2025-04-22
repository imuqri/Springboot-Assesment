package com.accenturebe.onlinefooddelivery.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 32, message = "Name must be between 8 and 32 characters")
    private String name ;

    @NotNull(message = "Price cannot be null")
//    @DecimalMin(value = "0.01", message = "Price must be at least 0.01")
    @DecimalMax(value = "9999.99", message = "Price must not exceed 9999.99")
    private double price;
}
