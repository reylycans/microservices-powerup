package com.pragma.hexagonal.application.dto.request;

import lombok.Data;

@Data
public class OrderDetailsRequestDto {
    private Long id;
    private DishRequestDto dish;
    private Long amount;
}
