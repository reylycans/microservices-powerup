package com.pragma.hexagonal.application.mapper.request;

import com.pragma.hexagonal.application.dto.request.OrderRequestDto;
import com.pragma.hexagonal.domain.model.OrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderRequestMapper {
    OrderModel toOrder(OrderRequestDto orderRequestDto);
}
