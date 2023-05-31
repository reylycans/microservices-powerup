package com.pragma.hexagonal.infraestructure.port.out.adapter;

import com.pragma.hexagonal.domain.model.RestaurantModel;
import com.pragma.hexagonal.domain.port.out.IRestaurantRepository;
import com.pragma.hexagonal.infraestructure.port.out.entity.RestaurantEntity;
import com.pragma.hexagonal.infraestructure.port.out.mapper.IRestaurantEntityMapper;
import com.pragma.hexagonal.infraestructure.port.out.repository.IRestaurantJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class RestaurantRepository implements IRestaurantRepository {

    private final IRestaurantJpaRepository restaurantJpaRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;

    @Override
    public void save(RestaurantModel restaurantModel) {
        restaurantJpaRepository.save(restaurantEntityMapper.toEntity(restaurantModel));
    }

    @Override
    public RestaurantModel getRestaurantById(Long id) {
        return null;
    }

    @Override
    public Optional<RestaurantModel> getRestaurantByOwner(Long ownerId) {
        Optional<RestaurantEntity> restaurantEntity = restaurantJpaRepository.findOneByOwnerId(ownerId);
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
    public Optional<List<RestaurantModel>> getAllRestaurantsWithPagination(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size, Sort.Direction.ASC,"name");
        Page<RestaurantEntity> restauntEntity = restaurantJpaRepository.findAll(pageRequest);
        List<RestaurantEntity> restaurantEntities = restauntEntity.getContent();
        if(restaurantEntities.isEmpty()){
            return Optional.empty();
        }
        return Optional.ofNullable(restaurantEntityMapper.toModelList(restaurantEntities));
    }

    @Override
    public void deleteRestaurantById(Long id) {

    }
}
