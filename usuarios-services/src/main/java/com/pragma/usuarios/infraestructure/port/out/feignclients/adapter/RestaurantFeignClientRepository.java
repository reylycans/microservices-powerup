package com.pragma.usuarios.infraestructure.port.out.feignclients.adapter;

import com.pragma.usuarios.domain.model.RestaurantModel;
import com.pragma.usuarios.domain.port.out.feignclients.IRestaurantFeignClientRepository;
import com.pragma.usuarios.infraestructure.port.out.feignclients.IRestaurantFeignClient;
import com.pragma.usuarios.infraestructure.port.out.feignclients.mapper.IRestaurantFeignMapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RestaurantFeignClientRepository implements IRestaurantFeignClientRepository {

    private final IRestaurantFeignClient restaurantFeignClient;
    private final IRestaurantFeignMapper restaurantFeignMapper;

    @Override
    public RestaurantModel getRestaurantByOwner(Long ownerId) {
        return restaurantFeignMapper.toModel(restaurantFeignClient.getRestaurantByOwner(ownerId));
    }
}
