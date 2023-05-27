package com.pragma.hexagonal.infraestructure.port.out.repository;

import com.pragma.hexagonal.infraestructure.port.out.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserJpaRepository extends JpaRepository<RestaurantEntity,Long> {

}
