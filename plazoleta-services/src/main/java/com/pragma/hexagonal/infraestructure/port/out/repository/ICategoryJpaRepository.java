package com.pragma.hexagonal.infraestructure.port.out.repository;

import com.pragma.hexagonal.infraestructure.port.out.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryJpaRepository extends JpaRepository<CategoryEntity,Long> {
    Optional<CategoryEntity> findOneByName(String name);
}
