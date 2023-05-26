package com.pragma.hexagonal.application.dto.request;

import lombok.Data;

@Data
public class RestaurantEmployeeRequestDto {
    private Long id;
    private RestaurantRequestDto restaurant;
    private Long userId;
}
