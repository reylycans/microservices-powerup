package com.pragma.usuarios.application.handler.impl;

import com.pragma.usuarios.application.dto.request.RolRequestDto;
import com.pragma.usuarios.application.handler.IRolHandler;
import com.pragma.usuarios.application.mapper.request.IRolRequestMapper;
import com.pragma.usuarios.domain.model.RolModel;
import com.pragma.usuarios.domain.port.in.IRolServicePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RolHandler implements IRolHandler {

    private final IRolServicePort rolServicePort;
    private final IRolRequestMapper rolRequestMapper;

    @Override
    public void save(RolRequestDto rolRequestDto) {
        RolModel rolModel = rolRequestMapper.toRol(rolRequestDto);
        rolServicePort.save(rolModel);
    }
}
