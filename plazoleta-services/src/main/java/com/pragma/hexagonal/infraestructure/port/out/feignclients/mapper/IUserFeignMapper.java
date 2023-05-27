package com.pragma.hexagonal.infraestructure.port.out.feignclients.mapper;

import com.pragma.hexagonal.domain.model.UserModel;
import com.pragma.hexagonal.infraestructure.port.out.feignclients.dto.UserFeignDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserFeignMapper {
    //@Mapping(target = "rol",source = "rol")
    UserModel toModel(UserFeignDto userFeignDto);
}
