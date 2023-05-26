package com.pragma.hexagonal.application.dto.response;

import com.pragma.hexagonal.domain.model.CategoryModel;
import com.pragma.hexagonal.domain.model.RestaurantModel;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class DishResponseDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private String urlImage;
    private RestaurantModel restaurant;
    private CategoryModel category;
}
