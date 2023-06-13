package com.pragma.hexagonal.infraestructure.port.out.adapter;

import com.pragma.hexagonal.domain.model.RestaurantEmployeeModel;
import com.pragma.hexagonal.domain.port.out.IRestaurantEmployeeRepository;
import com.pragma.hexagonal.infraestructure.port.out.entity.RestaurantEmployeeEntity;
import com.pragma.hexagonal.infraestructure.port.out.mapper.IRestaurantEmployeeEntityMapper;
import com.pragma.hexagonal.infraestructure.port.out.repository.IRestaurantEmployeeJpaRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class RestaurantEmployeeRepository implements IRestaurantEmployeeRepository {

    private final IRestaurantEmployeeJpaRepository restaurantEmployeeJpaRepository;
    private final IRestaurantEmployeeEntityMapper restaurantEmployeeEntityMapper;

    @Override
    public void save(RestaurantEmployeeModel restaurantEmployeeModel) {
        restaurantEmployeeJpaRepository.save(restaurantEmployeeEntityMapper.toEntity(restaurantEmployeeModel));
    }

    @Override
    public List<RestaurantEmployeeModel> getAllResturantEmployees() {
        return null;
    }

    @Override
    public Optional<RestaurantEmployeeModel> getRestaurantEmployeeById(Long employeeId) {
        Optional<RestaurantEmployeeEntity> restaurantEmployeeEntity = restaurantEmployeeJpaRepository.findByuserId(employeeId);
        if(!restaurantEmployeeEntity.isPresent()){
            return Optional.empty();
        }
        return Optional.ofNullable(restaurantEmployeeEntityMapper.toModel(restaurantEmployeeEntity.get()));
    }
}
