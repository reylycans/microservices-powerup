package com.pragma.hexagonal.domain.usecase;

import com.pragma.hexagonal.domain.model.RestaurantModel;
import com.pragma.hexagonal.domain.port.in.IRestaurantServicePort;
import com.pragma.hexagonal.domain.port.out.IRestaurantRepository;

import java.util.List;

public class RestaurantServicePort implements IRestaurantServicePort {

    private final IRestaurantRepository restaurantRepository;

    public RestaurantServicePort(IRestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void save(RestaurantModel restaurantModel) {

    }

    @Override
    public RestaurantModel getRestaurantById(Long id) {
        return null;
    }

    @Override
    public List<RestaurantModel> getAllRestaurants() {
        return null;
    }

    @Override
    public List<RestaurantModel> getAllRestaurantsWithPagination(Integer page, Integer size) {
        return null;
    }

    @Override
    public void deleteRestaurantById(Long id) {

    }
}
