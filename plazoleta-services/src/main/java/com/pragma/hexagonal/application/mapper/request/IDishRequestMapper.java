package com.pragma.hexagonal.application.mapper.request;

import com.pragma.hexagonal.application.dto.request.DishRequestDto;
import com.pragma.hexagonal.domain.model.DishModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDishRequestMapper {
    DishModel toModel(DishRequestDto dishRequestDto);
}
