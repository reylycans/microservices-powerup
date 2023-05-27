package com.pragma.usuarios.domain.port.in;

import com.pragma.usuarios.domain.model.RolModel;

import java.util.Optional;

public interface IRolServicePort {
    void save(RolModel rolModel);
    Optional<RolModel> findById(Long rolId);
}
