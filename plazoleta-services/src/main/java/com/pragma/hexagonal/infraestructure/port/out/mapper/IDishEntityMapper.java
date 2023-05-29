package com.pragma.hexagonal.infraestructure.port.out.mapper;

import com.pragma.hexagonal.domain.model.DishModel;
import com.pragma.hexagonal.infraestructure.port.out.entity.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDishEntityMapper {
    @Mapping(target = "category",source = "category")
    DishEntity toEntity(DishModel dishModel);
    @Mapping(target = "category",source = "category")
    DishModel toModel(DishEntity dishEntity);
}
