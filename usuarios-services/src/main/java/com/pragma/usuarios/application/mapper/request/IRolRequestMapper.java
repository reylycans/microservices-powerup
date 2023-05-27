package com.pragma.usuarios.application.mapper.request;

import com.pragma.usuarios.application.dto.request.RolRequestDto;
import com.pragma.usuarios.domain.model.RolModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRolRequestMapper {
    RolModel toRol(RolRequestDto rolRequestDto);
}
