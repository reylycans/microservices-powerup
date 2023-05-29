package com.pragma.hexagonal.infraestructure.port.out.repository;

import com.pragma.hexagonal.infraestructure.port.out.entity.RestaurantEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurantEmployeeJpaRepository extends JpaRepository<RestaurantEmployeeEntity,Long> {
}
