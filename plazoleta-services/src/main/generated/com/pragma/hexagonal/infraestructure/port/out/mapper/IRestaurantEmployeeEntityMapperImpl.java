package com.pragma.hexagonal.infraestructure.port.out.mapper;

import com.pragma.hexagonal.domain.model.RestaurantEmployeeModel;
import com.pragma.hexagonal.domain.model.RestaurantModel;
import com.pragma.hexagonal.infraestructure.port.out.entity.RestaurantEmployeeEntity;
import com.pragma.hexagonal.infraestructure.port.out.entity.RestaurantEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-30T15:54:49-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IRestaurantEmployeeEntityMapperImpl implements IRestaurantEmployeeEntityMapper {

    @Override
    public RestaurantEmployeeEntity toEntity(RestaurantEmployeeModel restaurantEmployeeModel) {
        if ( restaurantEmployeeModel == null ) {
            return null;
        }

        RestaurantEmployeeEntity restaurantEmployeeEntity = new RestaurantEmployeeEntity();

        restaurantEmployeeEntity.setId( restaurantEmployeeModel.getId() );
        restaurantEmployeeEntity.setRestaurant( restaurantModelToRestaurantEntity( restaurantEmployeeModel.getRestaurant() ) );
        restaurantEmployeeEntity.setUserId( restaurantEmployeeModel.getUserId() );

        return restaurantEmployeeEntity;
    }

    protected RestaurantEntity restaurantModelToRestaurantEntity(RestaurantModel restaurantModel) {
        if ( restaurantModel == null ) {
            return null;
        }

        RestaurantEntity restaurantEntity = new RestaurantEntity();

        restaurantEntity.setId( restaurantModel.getId() );
        restaurantEntity.setName( restaurantModel.getName() );
        restaurantEntity.setNit( restaurantModel.getNit() );
        restaurantEntity.setAddress( restaurantModel.getAddress() );
        restaurantEntity.setPhone( restaurantModel.getPhone() );
        restaurantEntity.setUrlLogo( restaurantModel.getUrlLogo() );
        restaurantEntity.setOwnerId( restaurantModel.getOwnerId() );

        return restaurantEntity;
    }
}
