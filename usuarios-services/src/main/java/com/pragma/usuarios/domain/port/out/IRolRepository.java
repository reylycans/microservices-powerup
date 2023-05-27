package com.pragma.usuarios.domain.port.out;

import com.pragma.usuarios.domain.model.RolModel;

import java.util.Optional;

public interface IRolRepository {
    void save(RolModel rolModel);
    Optional<RolModel> findById(Long rolId);
}
