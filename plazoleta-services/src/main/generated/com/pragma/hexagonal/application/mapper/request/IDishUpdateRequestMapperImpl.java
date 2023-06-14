package com.pragma.hexagonal.application.mapper.request;

import com.pragma.hexagonal.application.dto.request.DishUpdateRequestDto;
import com.pragma.hexagonal.domain.model.DishModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-14T15:46:35-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IDishUpdateRequestMapperImpl implements IDishUpdateRequestMapper {

    @Override
    public DishModel toUpdateModel(DishUpdateRequestDto dishUpdateRequestDto) {
        if ( dishUpdateRequestDto == null ) {
            return null;
        }

        DishModel dishModel = new DishModel();

        dishModel.setPrice( dishUpdateRequestDto.getPrice() );
        dishModel.setDescription( dishUpdateRequestDto.getDescription() );

        return dishModel;
    }
}
