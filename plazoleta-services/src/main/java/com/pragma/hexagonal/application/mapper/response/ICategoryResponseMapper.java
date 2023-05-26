package com.pragma.hexagonal.application.mapper.response;

import com.pragma.hexagonal.application.dto.response.CategoryResponseDto;
import com.pragma.hexagonal.domain.model.CategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoryResponseMapper {
    CategoryResponseDto toResponse(CategoryModel categoryModel);
    List<CategoryResponseDto> toResponseList(List<CategoryModel> categoryModels);
}
