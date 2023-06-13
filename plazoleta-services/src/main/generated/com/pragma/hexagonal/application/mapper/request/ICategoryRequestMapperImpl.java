package com.pragma.hexagonal.application.mapper.request;

import com.pragma.hexagonal.application.dto.request.CategoryRequestDto;
import com.pragma.hexagonal.domain.model.CategoryModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-13T12:49:05-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class ICategoryRequestMapperImpl implements ICategoryRequestMapper {

    @Override
    public CategoryModel toCategory(CategoryRequestDto categoryRequestDto) {
        if ( categoryRequestDto == null ) {
            return null;
        }

        CategoryModel categoryModel = new CategoryModel();

        categoryModel.setId( categoryRequestDto.getId() );
        categoryModel.setName( categoryRequestDto.getName() );
        categoryModel.setDescription( categoryRequestDto.getDescription() );

        return categoryModel;
    }
}
