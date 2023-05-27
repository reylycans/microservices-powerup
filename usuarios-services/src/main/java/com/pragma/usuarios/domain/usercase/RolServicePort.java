package com.pragma.usuarios.domain.usercase;

import com.pragma.usuarios.domain.model.RolModel;
import com.pragma.usuarios.domain.port.in.IRolServicePort;
import com.pragma.usuarios.domain.port.out.IRolRepository;

import java.util.Optional;

public class RolServicePort implements IRolServicePort {

    private final IRolRepository rolRepository;

    public RolServicePort(IRolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public void save(RolModel rolModel) {
       rolRepository.save(rolModel);
    }

    @Override
    public Optional<RolModel> findById(Long rolId) {
        return rolRepository.findById(rolId);
    }
}
