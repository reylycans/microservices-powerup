package com.pragma.hexagonal.domain.port.out;

import com.pragma.hexagonal.domain.model.RestaurantEmployeeModel;

import java.util.List;

public interface IRestaurantEmployeeRepository {
    void save(RestaurantEmployeeModel restaurantEmployeeModel);
    List<RestaurantEmployeeModel> getAllResturantEmployees();
}
