package com.pragma.usuarios.application.handler.impl;

import com.pragma.usuarios.application.dto.request.UserRequestDto;
import com.pragma.usuarios.application.dto.response.UserResponseDto;
import com.pragma.usuarios.application.handler.IUserHandler;
import com.pragma.usuarios.application.mapper.request.IUserRequestMapper;
import com.pragma.usuarios.application.mapper.response.IUserResponseMapper;
import com.pragma.usuarios.domain.model.UserModel;
import com.pragma.usuarios.domain.port.in.IUserServicePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class UserHandler implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;

    @Override
    @Transactional
    public void save(UserRequestDto userRequestDto) {
        UserModel userModel = userRequestMapper.toUser(userRequestDto);
        userServicePort.save(userModel);
    }

    @Override
    @Transactional
    public void saveEmployee(UserRequestDto userRequestDto) {
        UserModel userModel = userRequestMapper.toUser(userRequestDto);
        userServicePort.saveEmployee(userModel);
    }


    @Override
    @Transactional
    public UserResponseDto getUserById(Long id) {
        return userResponseMapper.toResponse(userServicePort.getUserById(id));
    }

    @Override
    public UserResponseDto getUserByEmail(String email) {
        return userResponseMapper.toResponse(userServicePort.getUserByEmail(email));
    }
}
