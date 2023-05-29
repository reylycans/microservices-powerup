package com.pragma.hexagonal.application.handler;

import com.pragma.hexagonal.application.dto.request.RestaurantRequestDto;
import com.pragma.hexagonal.application.dto.response.RestaurantResponseDto;

import java.util.List;

public interface IRestaurantHandler {
    void save(RestaurantRequestDto restaurantRequestDto);
    RestaurantResponseDto getRestaurantById(Long id);
    RestaurantResponseDto getRestaurantByOwner(Long ownerId);
    List<RestaurantResponseDto> getAllRestaurants();
    List<RestaurantResponseDto> getAllRestaurantsWithPagination(Integer page,Integer size);
    void deleteRestaurantById(Long id);

}
