package com.pragma.hexagonal.domain.usecase;

import com.pragma.hexagonal.domain.enums.RolEnum;
import com.pragma.hexagonal.domain.exception.RestaurantDomainException;
import com.pragma.hexagonal.domain.model.RestaurantModel;
import com.pragma.hexagonal.domain.model.UserModel;
import com.pragma.hexagonal.domain.port.in.IRestaurantServicePort;
import com.pragma.hexagonal.domain.port.out.IRestaurantRepository;
import com.pragma.hexagonal.domain.port.out.feignclients.IUserFeignClientRepository;

import java.util.List;

public class RestaurantServicePort implements IRestaurantServicePort {

    private final IRestaurantRepository restaurantRepository;
    private final IUserFeignClientRepository userFeignClientRepository;

    public RestaurantServicePort(IRestaurantRepository restaurantRepository,
                                 IUserFeignClientRepository userFeignClientRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userFeignClientRepository = userFeignClientRepository;
    }

    @Override
    public void save(RestaurantModel restaurantModel) {
        UserModel userModel = userFeignClientRepository.getUserById(restaurantModel.getOwnerId());
        if(userModel==null) throw new RestaurantDomainException("restaurant owner to create does not exist");
        if(!userModel.getRol().getName().equals(RolEnum.OWNER.getEtiqueta())) throw new RestaurantDomainException("user must be owner");

        restaurantRepository.save(restaurantModel);
    }

    @Override
    public RestaurantModel getRestaurantById(Long id) {
        return null;
    }

    @Override
    public List<RestaurantModel> getAllRestaurants() {
        return null;
    }

    @Override
    public List<RestaurantModel> getAllRestaurantsWithPagination(Integer page, Integer size) {
        return null;
    }

    @Override
    public void deleteRestaurantById(Long id) {

    }
}
