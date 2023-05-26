package com.pragma.hexagonal.application.handler.impl;

import com.pragma.hexagonal.application.dto.request.RestaurantEmployeeRequestDto;
import com.pragma.hexagonal.application.dto.response.RestaurantEmployeeResponseDto;
import com.pragma.hexagonal.application.handler.IRestaurantEmployeeHandler;
import com.pragma.hexagonal.application.mapper.request.IRestaurantEmployeeRequestMapper;
import com.pragma.hexagonal.application.mapper.response.IRestaurantEmployeeResponseMapper;
import com.pragma.hexagonal.domain.model.RestaurantEmployeeModel;
import com.pragma.hexagonal.domain.port.in.IRestaurantEmployeeServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RestaurantEmployeeHandler implements IRestaurantEmployeeHandler {

    private final IRestaurantEmployeeServicePort restaurantEmployeeServicePort;
    private final IRestaurantEmployeeRequestMapper restaurantEmployeeRequestMapper;
    private final IRestaurantEmployeeResponseMapper restaurantEmployeeResponseMapper;

    @Override
    public void save(RestaurantEmployeeRequestDto restaurantEmployeeRequestDto) {
        RestaurantEmployeeModel restaurantEmployeeModel = restaurantEmployeeRequestMapper
                                                         .toRestaurantEmployee(restaurantEmployeeRequestDto);
        restaurantEmployeeServicePort.save(restaurantEmployeeModel);
    }

    @Override
    public List<RestaurantEmployeeResponseDto> getAllResturantEmployees() {
        return restaurantEmployeeResponseMapper.toResponseList(restaurantEmployeeServicePort.getAllResturantEmployees());
    }
}
