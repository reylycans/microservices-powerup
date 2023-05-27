package com.pragma.usuarios.infraestructure.port.out.adapter;

import com.pragma.usuarios.domain.model.RolModel;
import com.pragma.usuarios.domain.port.out.IRolRepository;
import com.pragma.usuarios.infraestructure.port.out.mapper.IRolEntityMapper;
import com.pragma.usuarios.infraestructure.port.out.repository.IRolJpaRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class RolRepository implements IRolRepository {

    private final IRolJpaRepository rolJpaRepository;
    private final IRolEntityMapper rolEntityMapper;

    @Override
    public void save(RolModel rolModel) {
        rolJpaRepository.save(rolEntityMapper.toEntity(rolModel));
    }

    @Override
    public Optional<RolModel> findById(Long rolId) {
        return Optional.of(rolEntityMapper.toModel(rolJpaRepository.findById(rolId).get()));
    }
}
