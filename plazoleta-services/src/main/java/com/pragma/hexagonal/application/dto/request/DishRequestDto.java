package com.pragma.hexagonal.application.dto.request;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Data
public class DishRequestDto {
    private Long id;
    @NotNull(message = "name is required")
    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "price is required")
    @NotBlank(message = "price is required")
    private BigDecimal price;

    @NotNull(message = "description is required")
    @NotBlank(message = "description is required")
    private String description;

    @NotNull(message = "urlImage is required")
    @NotBlank(message = "urlImage is required")
    private String urlImage;

    @NotNull(message = "restaurant is required")
    @NotBlank(message = "restaurant is required")
    private RestaurantRequestDto restaurant;

    @NotNull(message = "category is required")
    @NotBlank(message = "category is required")
    private CategoryRequestDto category;
}
