package com.pragma.hexagonal.infraestructure.port.out.mapper;

import com.pragma.hexagonal.domain.model.RestaurantModel;
import com.pragma.hexagonal.infraestructure.port.out.entity.RestaurantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantEntityMapper {

    RestaurantEntity toEntity(RestaurantModel restaurantModel);
}
