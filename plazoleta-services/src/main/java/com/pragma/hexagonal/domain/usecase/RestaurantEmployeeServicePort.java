package com.pragma.hexagonal.domain.usecase;

import com.pragma.hexagonal.domain.model.RestaurantEmployeeModel;
import com.pragma.hexagonal.domain.port.in.IRestaurantEmployeeServicePort;
import com.pragma.hexagonal.domain.port.out.IRestaurantEmployeeRepository;

import java.util.List;

public class RestaurantEmployeeServicePort implements IRestaurantEmployeeServicePort {

    private final IRestaurantEmployeeRepository restaurantEmployeeRepository;

    public RestaurantEmployeeServicePort(IRestaurantEmployeeRepository restaurantEmployeeRepository) {
        this.restaurantEmployeeRepository = restaurantEmployeeRepository;
    }

    @Override
    public void save(RestaurantEmployeeModel restaurantEmployeeModel) {

    }

    @Override
    public List<RestaurantEmployeeModel> getAllResturantEmployees() {
        return null;
    }
}
