package com.pragma.hexagonal.infraestructure.port.out.repository;

import com.pragma.hexagonal.infraestructure.port.out.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRestaurantJpaRepository extends JpaRepository<RestaurantEntity,Long> {
     Optional<RestaurantEntity> findOneByOwnerId(Long ownerId);
}
