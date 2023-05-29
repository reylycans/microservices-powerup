package com.pragma.hexagonal.infraestructure.port.out.adapter;

import com.pragma.hexagonal.domain.model.RestaurantModel;
import com.pragma.hexagonal.domain.port.out.IRestaurantRepository;
import com.pragma.hexagonal.infraestructure.port.out.entity.RestaurantEntity;
import com.pragma.hexagonal.infraestructure.port.out.mapper.IRestaurantEntityMapper;
import com.pragma.hexagonal.infraestructure.port.out.repository.IUserJpaRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class RestaurantRepository implements IRestaurantRepository {

    private final IUserJpaRepository userJpaRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;

    @Override
    public void save(RestaurantModel restaurantModel) {
        userJpaRepository.save(restaurantEntityMapper.toEntity(restaurantModel));
    }

    @Override
    public RestaurantModel getRestaurantById(Long id) {
        return null;
    }

    @Override
    public Optional<RestaurantModel> getRestaurantByOwner(Long ownerId) {
        Optional<RestaurantEntity> restaurantEntity = userJpaRepository.findOneByOwnerId(ownerId);
        if(!restaurantEntity.isPresent()){
            return Optional.empty();
        }
        return Optional.ofNullable(restaurantEntityMapper.toModel(restaurantEntity.get()));
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
