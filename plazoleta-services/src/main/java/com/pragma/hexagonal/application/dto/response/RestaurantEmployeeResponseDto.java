package com.pragma.hexagonal.application.dto.response;

import com.pragma.hexagonal.domain.model.RestaurantModel;
import com.pragma.hexagonal.domain.model.UserModel;
import lombok.Data;

@Data
public class RestaurantEmployeeResponseDto {
    private Long id;
    private RestaurantModel restaurant;
    private UserModel user;
}
