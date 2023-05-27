package com.pragma.usuarios.infraestructure.port.out.adapter;

import com.pragma.usuarios.domain.model.UserModel;
import com.pragma.usuarios.domain.port.out.IUserRepository;
import com.pragma.usuarios.infraestructure.exception.InfraestructureException;
import com.pragma.usuarios.infraestructure.port.out.entity.UserEntity;
import com.pragma.usuarios.infraestructure.port.out.mapper.IUserEntityMapper;
import com.pragma.usuarios.infraestructure.port.out.repository.IUserJpaRepository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.Optional;


@AllArgsConstructor
public class UserRepository implements IUserRepository {

    private final IUserJpaRepository userJpaRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public void save(UserModel userModel) {
        userJpaRepository.save(userEntityMapper.toEntity(userModel));
    }

    @Override
    public Optional<UserModel> getUserById(Long id) {
        Optional<UserEntity> userEntity = userJpaRepository.findById(id);
        if(!userEntity.isPresent()){
            return Optional.empty();
        }
        return Optional.ofNullable(userEntityMapper.toUserModel(userEntity.get()));
    }

    @Override
    public Optional<UserModel>  getUserByEmail(String email) {
        Optional<UserEntity> userEntity = userJpaRepository.findOneByEmail(email);
        if(!userEntity.isPresent()){
            return Optional.empty();
        }
        return Optional.ofNullable(userEntityMapper.toUserModel(userEntity.get()));
    }
}
