package com.pragma.hexagonal.infraestructure.port.out.mapper;

import com.pragma.hexagonal.domain.model.RestaurantModel;
import com.pragma.hexagonal.infraestructure.port.out.entity.RestaurantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantEntityMapper {

    RestaurantEntity toEntity(RestaurantModel restaurantModel);

    RestaurantModel toModel(RestaurantEntity restaurantEntity);

    List<RestaurantModel> toModelList(List<RestaurantEntity> restaurantEntities);
}
