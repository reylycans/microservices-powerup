package com.pragma.hexagonal.domain.usecase;

import com.pragma.hexagonal.domain.enums.RolEnum;
import com.pragma.hexagonal.domain.exception.RestaurantDomainException;
import com.pragma.hexagonal.domain.model.RestaurantModel;
import com.pragma.hexagonal.domain.model.UserModel;
import com.pragma.hexagonal.domain.port.in.IRestaurantServicePort;
import com.pragma.hexagonal.domain.port.out.IRestaurantRepository;
import com.pragma.hexagonal.domain.port.out.feignclients.IUserFeignClientRepository;

import java.util.List;
import java.util.Optional;

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
        if(userModel==null) throw new RestaurantDomainException("Restaurant owner to create does not exist");
        if(!userModel.getRol().getName().equals(RolEnum.OWNER.getEtiqueta())) throw new RestaurantDomainException("User must be owner");

        restaurantRepository.save(restaurantModel);
    }

    @Override
    public RestaurantModel getRestaurantById(Long id) {
        return null;
    }

    @Override
    public RestaurantModel getRestaurantByOwner(Long ownerId) {
        Optional<RestaurantModel> restaurantModel = restaurantRepository.getRestaurantByOwner(ownerId);
        if(!restaurantModel.isPresent()){
            throw new RestaurantDomainException("Restaurant not found");
        }
        return restaurantModel.get();
    }

    @Override
    public List<RestaurantModel> getAllRestaurants() {
        return null;
    }

    @Override
    public List<RestaurantModel> getAllRestaurantsWithPagination(Integer page, Integer size) {
        Optional<List<RestaurantModel>> restaurantModels = restaurantRepository.getAllRestaurantsWithPagination(page,size);
        if(!restaurantModels.isPresent()){
            throw new RestaurantDomainException("Could not find a list of restaurants");
        }
        return restaurantModels.get();
    }

    @Override
    public void deleteRestaurantById(Long id) {

    }
}
