package com.pragma.usuarios.domain.port.in;

import com.pragma.usuarios.domain.model.RolModel;

public interface IRolServicePort {
    void save(RolModel rolModel);
}
