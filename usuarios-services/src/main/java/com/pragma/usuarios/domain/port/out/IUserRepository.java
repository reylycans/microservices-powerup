package com.pragma.usuarios.domain.port.out;

import com.pragma.usuarios.domain.model.UserModel;

import java.util.Optional;

public interface IUserRepository {
    UserModel save(UserModel userModel);
    Optional<UserModel> getUserById(Long id);
    Optional<UserModel> getUserByEmail(String email);
}
