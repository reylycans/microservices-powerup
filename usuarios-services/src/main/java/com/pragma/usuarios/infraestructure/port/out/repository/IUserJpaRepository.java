package com.pragma.usuarios.infraestructure.port.out.repository;

import com.pragma.usuarios.infraestructure.port.out.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserJpaRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findOneByEmail(String email);
}
