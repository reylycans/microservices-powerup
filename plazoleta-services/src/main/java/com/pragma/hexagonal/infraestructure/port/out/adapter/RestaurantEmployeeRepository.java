package com.pragma.hexagonal.infraestructure.port.out.adapter;

import com.pragma.hexagonal.domain.model.RestaurantEmployeeModel;
import com.pragma.hexagonal.domain.port.out.IRestaurantEmployeeRepository;

import java.util.List;

public class RestaurantEmployeeRepository implements IRestaurantEmployeeRepository {

    @Override
    public void save(RestaurantEmployeeModel restaurantEmployeeModel) {

    }

    @Override
    public List<RestaurantEmployeeModel> getAllResturantEmployees() {
        return null;
    }
}
