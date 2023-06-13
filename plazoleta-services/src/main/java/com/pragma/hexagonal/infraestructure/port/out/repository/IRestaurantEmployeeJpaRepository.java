package com.pragma.hexagonal.infraestructure.port.out.repository;

import com.pragma.hexagonal.domain.model.RestaurantEmployeeModel;
import com.pragma.hexagonal.infraestructure.port.out.entity.RestaurantEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRestaurantEmployeeJpaRepository extends JpaRepository<RestaurantEmployeeEntity,Long> {

    Optional<RestaurantEmployeeEntity> findByuserId(Long employeeId);
}
