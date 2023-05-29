package com.pragma.usuarios.infraestructure.port.out.feignclients.mapper;

import com.pragma.usuarios.domain.model.RestaurantModel;
import com.pragma.usuarios.infraestructure.port.out.feignclients.dto.RestaurantFeignDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantFeignMapper {

    RestaurantModel toModel(RestaurantFeignDto restaurantFeignDto);
}
