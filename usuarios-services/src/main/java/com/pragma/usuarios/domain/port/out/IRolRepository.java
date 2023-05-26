package com.pragma.usuarios.domain.port.out;

import com.pragma.usuarios.domain.model.RolModel;

public interface IRolRepository {
    void save(RolModel rolModel);
}
