package com.pragma.hexagonal.application.mapper.request;

import com.pragma.hexagonal.application.dto.request.RestaurantEmployeeRequestDto;
import com.pragma.hexagonal.application.dto.request.RestaurantRequestDto;
import com.pragma.hexagonal.domain.model.RestaurantEmployeeModel;
import com.pragma.hexagonal.domain.model.RestaurantModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-29T16:34:51-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IRestaurantEmployeeRequestMapperImpl implements IRestaurantEmployeeRequestMapper {

    @Override
    public RestaurantEmployeeModel toRestaurantEmployee(RestaurantEmployeeRequestDto restaurantEmployeeRequestDto) {
        if ( restaurantEmployeeRequestDto == null ) {
            return null;
        }

        RestaurantEmployeeModel restaurantEmployeeModel = new RestaurantEmployeeModel();

        restaurantEmployeeModel.setId( restaurantEmployeeRequestDto.getId() );
        restaurantEmployeeModel.setRestaurant( restaurantRequestDtoToRestaurantModel( restaurantEmployeeRequestDto.getRestaurant() ) );
        restaurantEmployeeModel.setUserId( restaurantEmployeeRequestDto.getUserId() );

        return restaurantEmployeeModel;
    }

    protected RestaurantModel restaurantRequestDtoToRestaurantModel(RestaurantRequestDto restaurantRequestDto) {
        if ( restaurantRequestDto == null ) {
            return null;
        }

        RestaurantModel restaurantModel = new RestaurantModel();

        restaurantModel.setId( restaurantRequestDto.getId() );
        restaurantModel.setName( restaurantRequestDto.getName() );
        restaurantModel.setNit( restaurantRequestDto.getNit() );
        restaurantModel.setAddress( restaurantRequestDto.getAddress() );
        restaurantModel.setPhone( restaurantRequestDto.getPhone() );
        restaurantModel.setUrlLogo( restaurantRequestDto.getUrlLogo() );
        restaurantModel.setOwnerId( restaurantRequestDto.getOwnerId() );

        return restaurantModel;
    }
}
