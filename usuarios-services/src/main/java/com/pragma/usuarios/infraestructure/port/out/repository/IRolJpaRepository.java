package com.pragma.usuarios.infraestructure.port.out.repository;

import com.pragma.usuarios.infraestructure.port.out.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolJpaRepository extends JpaRepository<RolEntity,Long> {

}
