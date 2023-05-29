package com.pragma.usuarios.infraestructure.port.out.feignclients.mapper;

import com.pragma.usuarios.domain.model.RestaurantEmployeeModel;
import com.pragma.usuarios.infraestructure.port.out.feignclients.dto.RestaurantEmployeeFeignDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantEmployeeFeignMapper {
    RestaurantEmployeeFeignDto toFeign(RestaurantEmployeeModel restaurantEmployeeModel);
}
