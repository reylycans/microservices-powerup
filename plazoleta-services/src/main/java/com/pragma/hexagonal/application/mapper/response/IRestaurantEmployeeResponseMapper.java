package com.pragma.hexagonal.application.mapper.response;

import com.pragma.hexagonal.application.dto.response.RestaurantEmployeeResponseDto;
import com.pragma.hexagonal.domain.model.RestaurantEmployeeModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantEmployeeResponseMapper {
    RestaurantEmployeeResponseDto toResponse(RestaurantEmployeeModel restaurantEmployeeModel);
    List<RestaurantEmployeeResponseDto> toResponseList(List<RestaurantEmployeeModel> restaurantEmployeeModels);
}
