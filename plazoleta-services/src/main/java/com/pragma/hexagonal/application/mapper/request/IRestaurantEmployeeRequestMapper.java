package com.pragma.hexagonal.application.mapper.request;

import com.pragma.hexagonal.application.dto.request.RestaurantEmployeeRequestDto;
import com.pragma.hexagonal.domain.model.RestaurantEmployeeModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantEmployeeRequestMapper {
    RestaurantEmployeeModel toRestaurantEmployee(RestaurantEmployeeRequestDto restaurantEmployeeRequestDto);
}
