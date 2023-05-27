package com.pragma.hexagonal.domain.port.out.feignclients;

import com.pragma.hexagonal.domain.model.UserModel;

public interface IUserFeignClientRepository {
    UserModel getUserById(Long userId);
}
