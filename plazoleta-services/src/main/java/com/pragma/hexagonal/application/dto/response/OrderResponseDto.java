package com.pragma.hexagonal.application.dto.response;

import com.pragma.hexagonal.domain.model.OrderDetailModel;
import com.pragma.hexagonal.domain.model.RestaurantModel;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class OrderResponseDto {
    private Long id;
    private Long customerId;
    private LocalDate createAt;
    private String state;
    private RestaurantModel restaurant;
    private List<OrderDetailModel> dishes;
}
