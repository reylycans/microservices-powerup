package com.pragma.hexagonal.application.dto.request;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class DishRequestDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private String urlImage;
    private RestaurantRequestDto restaurant;
    private CategoryRequestDto category;
}
