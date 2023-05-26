package com.pragma.usuarios.infraestructure.port.out.adapter;

import com.pragma.usuarios.domain.model.UserModel;
import com.pragma.usuarios.domain.port.out.IUserRepository;
import com.pragma.usuarios.infraestructure.port.out.mapper.IUserEntityMapper;
import com.pragma.usuarios.infraestructure.port.out.repository.IUserJpaRepository;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class UserRepository implements IUserRepository {

    private final IUserJpaRepository userJpaRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public void save(UserModel userModel) {
        userJpaRepository.save(userEntityMapper.toEntity(userModel));
    }
}
