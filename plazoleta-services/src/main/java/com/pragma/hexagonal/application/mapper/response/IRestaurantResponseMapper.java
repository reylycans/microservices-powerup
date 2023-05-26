package com.pragma.hexagonal.application.mapper.response;

import com.pragma.hexagonal.application.dto.response.RestaurantResponseDto;
import com.pragma.hexagonal.domain.model.RestaurantModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantResponseMapper {
    RestaurantResponseDto toResponse(RestaurantModel restaurantModel);
    List<RestaurantResponseDto> toResponseList(List<RestaurantModel> restaurantModels);
}
