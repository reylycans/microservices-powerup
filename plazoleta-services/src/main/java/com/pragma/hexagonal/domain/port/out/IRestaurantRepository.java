package com.pragma.hexagonal.domain.port.out;

import com.pragma.hexagonal.domain.model.RestaurantModel;

import java.util.List;

public interface IRestaurantRepository {
    void save(RestaurantModel restaurantModel);
    RestaurantModel getRestaurantById(Long id);
    List<RestaurantModel> getAllRestaurants();
    List<RestaurantModel> getAllRestaurantsWithPagination(Integer page,Integer size);
    void deleteRestaurantById(Long id);
}
