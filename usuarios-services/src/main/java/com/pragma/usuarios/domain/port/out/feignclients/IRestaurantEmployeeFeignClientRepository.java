package com.pragma.usuarios.domain.port.out.feignclients;

import com.pragma.usuarios.domain.model.RestaurantEmployeeModel;

public interface IRestaurantEmployeeFeignClientRepository {
    void saveRestaurantEmployee(RestaurantEmployeeModel restaurantEmployeeModel);
}
