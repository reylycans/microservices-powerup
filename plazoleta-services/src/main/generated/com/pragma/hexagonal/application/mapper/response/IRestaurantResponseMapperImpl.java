package com.pragma.hexagonal.application.mapper.response;

import com.pragma.hexagonal.application.dto.response.RestaurantResponseDto;
import com.pragma.hexagonal.domain.model.RestaurantModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-14T15:46:35-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IRestaurantResponseMapperImpl implements IRestaurantResponseMapper {

    @Override
    public RestaurantResponseDto toResponse(RestaurantModel restaurantModel) {
        if ( restaurantModel == null ) {
            return null;
        }

        RestaurantResponseDto restaurantResponseDto = new RestaurantResponseDto();

        restaurantResponseDto.setId( restaurantModel.getId() );
        restaurantResponseDto.setName( restaurantModel.getName() );
        restaurantResponseDto.setNit( restaurantModel.getNit() );
        restaurantResponseDto.setAddress( restaurantModel.getAddress() );
        restaurantResponseDto.setPhone( restaurantModel.getPhone() );
        restaurantResponseDto.setUrlLogo( restaurantModel.getUrlLogo() );

        return restaurantResponseDto;
    }

    @Override
    public List<RestaurantResponseDto> toResponseList(List<RestaurantModel> restaurantModels) {
        if ( restaurantModels == null ) {
            return null;
        }

        List<RestaurantResponseDto> list = new ArrayList<RestaurantResponseDto>( restaurantModels.size() );
        for ( RestaurantModel restaurantModel : restaurantModels ) {
            list.add( toResponse( restaurantModel ) );
        }

        return list;
    }
}
