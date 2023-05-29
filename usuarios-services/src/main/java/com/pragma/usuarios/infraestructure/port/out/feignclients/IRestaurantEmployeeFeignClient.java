package com.pragma.usuarios.infraestructure.port.out.feignclients;

import com.pragma.usuarios.infraestructure.port.out.feignclients.dto.RestaurantEmployeeFeignDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(contextId = "restaurantEmployee",name = "plazoleta-service",url = "localhost:8082/api/restaurantEmployee")
public interface IRestaurantEmployeeFeignClient {

    @PostMapping
    void saveRestaurantEmployee(RestaurantEmployeeFeignDto restaurantEmployeeFeignDto);
}
