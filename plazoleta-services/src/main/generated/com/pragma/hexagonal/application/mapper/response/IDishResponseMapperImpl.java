package com.pragma.hexagonal.application.mapper.response;

import com.pragma.hexagonal.application.dto.response.DishResponseDto;
import com.pragma.hexagonal.domain.model.DishModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-27T18:49:51-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IDishResponseMapperImpl implements IDishResponseMapper {

    @Override
    public DishResponseDto toResponse(DishModel dishModel) {
        if ( dishModel == null ) {
            return null;
        }

        DishResponseDto dishResponseDto = new DishResponseDto();

        dishResponseDto.setId( dishModel.getId() );
        dishResponseDto.setName( dishModel.getName() );
        dishResponseDto.setPrice( dishModel.getPrice() );
        dishResponseDto.setDescription( dishModel.getDescription() );
        dishResponseDto.setUrlImage( dishModel.getUrlImage() );
        dishResponseDto.setRestaurant( dishModel.getRestaurant() );
        dishResponseDto.setCategory( dishModel.getCategory() );

        return dishResponseDto;
    }

    @Override
    public List<DishResponseDto> toResponseList(List<DishModel> dishModels) {
        if ( dishModels == null ) {
            return null;
        }

        List<DishResponseDto> list = new ArrayList<DishResponseDto>( dishModels.size() );
        for ( DishModel dishModel : dishModels ) {
            list.add( toResponse( dishModel ) );
        }

        return list;
    }
}
