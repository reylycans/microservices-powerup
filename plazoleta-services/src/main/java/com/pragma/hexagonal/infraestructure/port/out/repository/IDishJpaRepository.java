package com.pragma.hexagonal.infraestructure.port.out.repository;

import com.pragma.hexagonal.infraestructure.port.out.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IDishJpaRepository extends JpaRepository<DishEntity,Long> {
    Optional<DishEntity> findOneByName(String name);
}
