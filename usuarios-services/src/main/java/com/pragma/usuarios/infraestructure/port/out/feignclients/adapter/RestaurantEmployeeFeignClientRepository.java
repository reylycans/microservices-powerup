package com.pragma.usuarios.infraestructure.port.out.feignclients.adapter;

import com.pragma.usuarios.domain.model.RestaurantEmployeeModel;
import com.pragma.usuarios.domain.port.out.feignclients.IRestaurantEmployeeFeignClientRepository;
import com.pragma.usuarios.infraestructure.port.out.feignclients.IRestaurantEmployeeFeignClient;
import com.pragma.usuarios.infraestructure.port.out.feignclients.dto.RestaurantEmployeeFeignDto;
import com.pragma.usuarios.infraestructure.port.out.feignclients.mapper.IRestaurantEmployeeFeignMapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RestaurantEmployeeFeignClientRepository implements IRestaurantEmployeeFeignClientRepository {

    private final IRestaurantEmployeeFeignClient restaurantEmployeeFeignClient;
    private final IRestaurantEmployeeFeignMapper restaurantEmployeeFeignMapper;
    @Override
    public void saveRestaurantEmployee(RestaurantEmployeeModel restaurantEmployeeModel) {
        RestaurantEmployeeFeignDto restaurantEmployeeFeignDto = restaurantEmployeeFeignMapper.toFeign(restaurantEmployeeModel);
        restaurantEmployeeFeignClient.saveRestaurantEmployee(restaurantEmployeeFeignDto);
    }
}
