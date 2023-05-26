package com.pragma.hexagonal.domain.port.in;

import com.pragma.hexagonal.domain.model.RestaurantModel;

import java.util.List;

public interface IRestaurantServicePort {
    void save(RestaurantModel restaurantModel);
    RestaurantModel getRestaurantById(Long id);
    List<RestaurantModel> getAllRestaurants();
    List<RestaurantModel> getAllRestaurantsWithPagination(Integer page,Integer size);
    void deleteRestaurantById(Long id);
}
