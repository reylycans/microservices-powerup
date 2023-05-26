package com.pragma.hexagonal.application.mapper.response;

import com.pragma.hexagonal.application.dto.response.OrderResponseDto;
import com.pragma.hexagonal.domain.model.OrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderResponseMapper {
    OrderResponseDto toResponse(OrderModel orderModel);
    List<OrderResponseDto> toResponseList(List<OrderModel> orderModels);
}
