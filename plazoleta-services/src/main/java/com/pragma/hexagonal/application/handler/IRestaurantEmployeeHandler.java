package com.pragma.hexagonal.application.handler;

import com.pragma.hexagonal.application.dto.request.RestaurantEmployeeRequestDto;
import com.pragma.hexagonal.application.dto.response.RestaurantEmployeeResponseDto;

import java.util.List;

public interface IRestaurantEmployeeHandler {
    void save(RestaurantEmployeeRequestDto restaurantEmployeeRequestDto);
    List<RestaurantEmployeeResponseDto> getAllResturantEmployees();
}
