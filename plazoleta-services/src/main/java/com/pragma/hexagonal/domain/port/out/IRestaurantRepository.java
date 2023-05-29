package com.pragma.hexagonal.domain.port.out;

import com.pragma.hexagonal.domain.model.RestaurantModel;

import java.util.List;
import java.util.Optional;

public interface IRestaurantRepository {
    void save(RestaurantModel restaurantModel);
    RestaurantModel getRestaurantById(Long id);
    Optional<RestaurantModel> getRestaurantByOwner(Long ownerId);
    List<RestaurantModel> getAllRestaurants();
    List<RestaurantModel> getAllRestaurantsWithPagination(Integer page,Integer size);
    void deleteRestaurantById(Long id);
}
