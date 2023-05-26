package com.pragma.usuarios.application.mapper;

import com.pragma.usuarios.application.dto.RolRequestDto;
import com.pragma.usuarios.domain.model.RolModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRolRequestMapper {
    RolModel toRol(RolRequestDto rolRequestDto);
}
