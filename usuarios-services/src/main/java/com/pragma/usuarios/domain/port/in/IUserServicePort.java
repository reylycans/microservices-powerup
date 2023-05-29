package com.pragma.usuarios.domain.port.in;
import com.pragma.usuarios.domain.model.UserModel;

public interface IUserServicePort {
    UserModel save(UserModel userModel);
    void saveEmployee(UserModel userModel);
    UserModel getUserById(Long id);
    UserModel getUserByEmail(String email);
}
