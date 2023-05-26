package com.pragma.usuarios.domain.usercase;

import com.pragma.usuarios.domain.model.UserModel;
import com.pragma.usuarios.domain.port.in.IUserServicePort;
import com.pragma.usuarios.domain.port.out.IUserRepository;

public class UserServicePort implements IUserServicePort {

    private final IUserRepository userRepository;

    public UserServicePort(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(UserModel userModel) {
       userRepository.save(userModel);
    }
}
