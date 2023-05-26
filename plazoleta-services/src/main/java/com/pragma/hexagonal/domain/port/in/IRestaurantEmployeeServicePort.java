package com.pragma.hexagonal.domain.port.in;

import com.pragma.hexagonal.domain.model.RestaurantEmployeeModel;

import java.util.List;

public interface IRestaurantEmployeeServicePort {
    void save(RestaurantEmployeeModel restaurantEmployeeModel);
    List<RestaurantEmployeeModel> getAllResturantEmployees();
}
