package com.pragma.usuarios.application.handler;

import com.pragma.usuarios.application.dto.UserRequestDto;

public interface IUserHandler {
    void save(UserRequestDto userRequestDto);
}
