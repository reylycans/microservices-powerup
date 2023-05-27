package com.pragma.usuarios.application.mapper.response;
import com.pragma.usuarios.application.dto.response.UserResponseDto;
import com.pragma.usuarios.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserResponseMapper {
    @Mapping(target = "rol",source = "rol")
    UserResponseDto toResponse(UserModel userModel);
}
