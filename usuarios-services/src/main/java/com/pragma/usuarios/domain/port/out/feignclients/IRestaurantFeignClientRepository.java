package com.pragma.usuarios.domain.port.out.feignclients;

import com.pragma.usuarios.domain.model.RestaurantModel;

public interface IRestaurantFeignClientRepository {
   RestaurantModel getRestaurantByOwner(Long ownerId);
}
