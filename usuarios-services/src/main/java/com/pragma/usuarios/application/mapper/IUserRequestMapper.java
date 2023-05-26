package com.pragma.usuarios.application.mapper;

import com.pragma.usuarios.application.dto.UserRequestDto;
import com.pragma.usuarios.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {
    @Mapping(target = "rol",source = "rol")
    UserModel toUser(UserRequestDto userRequestDto);
}
