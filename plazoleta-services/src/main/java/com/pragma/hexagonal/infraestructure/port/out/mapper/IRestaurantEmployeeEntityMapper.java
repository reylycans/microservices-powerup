package com.pragma.hexagonal.infraestructure.port.out.mapper;

import com.pragma.hexagonal.domain.model.RestaurantEmployeeModel;
import com.pragma.hexagonal.infraestructure.port.out.entity.RestaurantEmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantEmployeeEntityMapper {

    RestaurantEmployeeEntity toEntity(RestaurantEmployeeModel restaurantEmployeeModel);
    RestaurantEmployeeModel toModel(RestaurantEmployeeEntity restaurantEmployeeEntity);
}
