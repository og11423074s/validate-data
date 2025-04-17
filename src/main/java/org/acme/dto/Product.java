package org.acme.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Product {

    public Long id;

    @NotBlank(message = "Label is mandatory")
    public String label;

    @NotBlank(message = "Description is mandatory")
    public String description;

    @Min(message = "Quantity must be greater than 0", value = 1)
    public Integer quantity;

    @Min(message = "Price must be greater than 0", value = 1)
    public Double price;
}
