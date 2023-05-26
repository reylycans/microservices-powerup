package com.pragma.hexagonal.application.handler.impl;

import com.pragma.hexagonal.application.dto.request.RestaurantRequestDto;
import com.pragma.hexagonal.application.dto.response.RestaurantResponseDto;
import com.pragma.hexagonal.application.handler.IRestaurantHandler;
import com.pragma.hexagonal.application.mapper.request.IResturantRequestMapper;
import com.pragma.hexagonal.application.mapper.response.IRestaurantResponseMapper;
import com.pragma.hexagonal.domain.model.RestaurantModel;
import com.pragma.hexagonal.domain.port.in.IRestaurantServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RestaurantHandler implements IRestaurantHandler {

    private final IRestaurantServicePort restaurantServicePort;
    private final IResturantRequestMapper resturantRequestMapper;
    private final IRestaurantResponseMapper restaurantResponseMapper;

    @Override
    public void save(RestaurantRequestDto restaurantRequestDto) {
        RestaurantModel restaurantModel = resturantRequestMapper.toRestaurant(restaurantRequestDto);
        restaurantServicePort.save(restaurantModel);
    }

    @Override
    public RestaurantResponseDto getRestaurantById(Long id) {
        return restaurantResponseMapper.toResponse(restaurantServicePort.getRestaurantById(id));
    }

    @Override
    public List<RestaurantResponseDto> getAllRestaurants() {
        return restaurantResponseMapper.toResponseList(restaurantServicePort.getAllRestaurants());
    }

    @Override
    public List<RestaurantResponseDto> getAllRestaurantsWithPagination(Integer page, Integer size) {
        return restaurantResponseMapper.toResponseList(restaurantServicePort.getAllRestaurantsWithPagination(page,size));
    }

    @Override
    public void deleteRestaurantById(Long id) {
        restaurantServicePort.deleteRestaurantById(id);
    }
}
