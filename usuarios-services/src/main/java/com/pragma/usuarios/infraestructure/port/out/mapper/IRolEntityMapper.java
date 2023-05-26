package com.pragma.usuarios.infraestructure.port.out.mapper;

import com.pragma.usuarios.domain.model.RolModel;
import com.pragma.usuarios.infraestructure.port.out.entity.RolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRolEntityMapper {
    RolEntity toEntity(RolModel rolModel);
}
