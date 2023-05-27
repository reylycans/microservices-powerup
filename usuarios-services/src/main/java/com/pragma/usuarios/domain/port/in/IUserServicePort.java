package com.pragma.usuarios.domain.port.in;

import com.pragma.usuarios.domain.model.UserModel;

public interface IUserServicePort {
    void save(UserModel userModel);
    UserModel getUserById(Long id);
    UserModel getUserByEmail(String email);
}
