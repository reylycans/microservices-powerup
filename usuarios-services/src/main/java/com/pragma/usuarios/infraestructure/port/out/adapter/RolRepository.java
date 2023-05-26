package com.pragma.usuarios.infraestructure.port.out.adapter;

import com.pragma.usuarios.domain.model.RolModel;
import com.pragma.usuarios.domain.port.out.IRolRepository;
import com.pragma.usuarios.infraestructure.port.out.mapper.IRolEntityMapper;
import com.pragma.usuarios.infraestructure.port.out.repository.IRolJpaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RolRepository implements IRolRepository {

    private final IRolJpaRepository rolJpaRepository;
    private final IRolEntityMapper rolEntityMapper;

    @Override
    public void save(RolModel rolModel) {
        rolJpaRepository.save(rolEntityMapper.toEntity(rolModel));
    }
}
