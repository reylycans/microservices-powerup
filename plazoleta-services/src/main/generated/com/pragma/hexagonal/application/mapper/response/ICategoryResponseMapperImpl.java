package com.pragma.hexagonal.application.mapper.response;

import com.pragma.hexagonal.application.dto.response.CategoryResponseDto;
import com.pragma.hexagonal.domain.model.CategoryModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-29T13:43:08-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class ICategoryResponseMapperImpl implements ICategoryResponseMapper {

    @Override
    public CategoryResponseDto toResponse(CategoryModel categoryModel) {
        if ( categoryModel == null ) {
            return null;
        }

        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();

        categoryResponseDto.setId( categoryModel.getId() );
        categoryResponseDto.setName( categoryModel.getName() );
        categoryResponseDto.setDescription( categoryModel.getDescription() );

        return categoryResponseDto;
    }

    @Override
    public List<CategoryResponseDto> toResponseList(List<CategoryModel> categoryModels) {
        if ( categoryModels == null ) {
            return null;
        }

        List<CategoryResponseDto> list = new ArrayList<CategoryResponseDto>( categoryModels.size() );
        for ( CategoryModel categoryModel : categoryModels ) {
            list.add( toResponse( categoryModel ) );
        }

        return list;
    }
}
