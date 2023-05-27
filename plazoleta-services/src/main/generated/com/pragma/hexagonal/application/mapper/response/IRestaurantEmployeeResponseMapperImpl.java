package com.pragma.hexagonal.application.mapper.response;

import com.pragma.hexagonal.application.dto.response.RestaurantEmployeeResponseDto;
import com.pragma.hexagonal.domain.model.RestaurantEmployeeModel;
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
public class IRestaurantEmployeeResponseMapperImpl implements IRestaurantEmployeeResponseMapper {

    @Override
    public RestaurantEmployeeResponseDto toResponse(RestaurantEmployeeModel restaurantEmployeeModel) {
        if ( restaurantEmployeeModel == null ) {
            return null;
        }

        RestaurantEmployeeResponseDto restaurantEmployeeResponseDto = new RestaurantEmployeeResponseDto();

        restaurantEmployeeResponseDto.setId( restaurantEmployeeModel.getId() );
        restaurantEmployeeResponseDto.setRestaurant( restaurantEmployeeModel.getRestaurant() );
        restaurantEmployeeResponseDto.setUser( restaurantEmployeeModel.getUser() );

        return restaurantEmployeeResponseDto;
    }

    @Override
    public List<RestaurantEmployeeResponseDto> toResponseList(List<RestaurantEmployeeModel> restaurantEmployeeModels) {
        if ( restaurantEmployeeModels == null ) {
            return null;
        }

        List<RestaurantEmployeeResponseDto> list = new ArrayList<RestaurantEmployeeResponseDto>( restaurantEmployeeModels.size() );
        for ( RestaurantEmployeeModel restaurantEmployeeModel : restaurantEmployeeModels ) {
            list.add( toResponse( restaurantEmployeeModel ) );
        }

        return list;
    }
}
