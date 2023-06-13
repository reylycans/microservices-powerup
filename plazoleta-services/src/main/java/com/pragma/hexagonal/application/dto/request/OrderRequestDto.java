package com.pragma.hexagonal.application.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class OrderRequestDto {
    private Long id;
    private Long customerId;
    private LocalDate createAt;
    private String state;
    private RestaurantRequestDto restaurant;
    private Set<OrderDetailsRequestDto> dishes;
}
