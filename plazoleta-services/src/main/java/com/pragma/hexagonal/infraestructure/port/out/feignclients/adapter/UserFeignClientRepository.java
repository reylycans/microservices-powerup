package com.pragma.hexagonal.infraestructure.port.out.feignclients.adapter;

import com.pragma.hexagonal.domain.model.UserModel;
import com.pragma.hexagonal.domain.port.out.feignclients.IUserFeignClientRepository;
import com.pragma.hexagonal.infraestructure.port.out.feignclients.IUserFeignClient;
import com.pragma.hexagonal.infraestructure.port.out.feignclients.mapper.IUserFeignMapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserFeignClientRepository implements IUserFeignClientRepository {

    private final IUserFeignClient userFeignClient;
    private final IUserFeignMapper userFeignMapper;
    @Override
    public UserModel getUserById(Long userId) {
        return userFeignMapper.toModel(userFeignClient.getUserById(userId));
    }
}
