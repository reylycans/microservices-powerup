package com.pragma.usuarios.infraestructure.port.out.feignclients;

import com.pragma.usuarios.infraestructure.port.out.feignclients.dto.RestaurantFeignDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "restaurant",name = "plazoleta-service",url = "localhost:8082/api/restaurant")
public interface IRestaurantFeignClient {

    @GetMapping
    RestaurantFeignDto getRestaurantByOwner(@RequestParam(value = "ownerId") Long ownerId);
}
