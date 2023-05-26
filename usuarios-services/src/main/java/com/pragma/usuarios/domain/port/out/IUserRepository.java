package com.pragma.usuarios.domain.port.out;

import com.pragma.usuarios.domain.model.UserModel;

public interface IUserRepository {
    void save(UserModel userModel);
}
