package com.pragma.usuarios.infraestructure.port.out.mapper;

import com.pragma.usuarios.domain.model.UserModel;
import com.pragma.usuarios.infraestructure.port.out.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {

    @Mapping(target = "rol",source = "rol")
    UserModel toUserModel(UserEntity userEntity);

    UserEntity toEntity(UserModel userModel);
}
