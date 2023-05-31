package com.pragma.usuarios.infraestructure.port.out.feignclients.mapper;

import com.pragma.usuarios.domain.model.RestaurantEmployeeModel;
import com.pragma.usuarios.domain.model.RestaurantModel;
import com.pragma.usuarios.infraestructure.port.out.feignclients.dto.RestaurantEmployeeFeignDto;
import com.pragma.usuarios.infraestructure.port.out.feignclients.dto.RestaurantFeignDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-30T15:45:47-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IRestaurantEmployeeFeignMapperImpl implements IRestaurantEmployeeFeignMapper {

    @Override
    public RestaurantEmployeeFeignDto toFeign(RestaurantEmployeeModel restaurantEmployeeModel) {
        if ( restaurantEmployeeModel == null ) {
            return null;
        }

        RestaurantEmployeeFeignDto restaurantEmployeeFeignDto = new RestaurantEmployeeFeignDto();

        restaurantEmployeeFeignDto.setId( restaurantEmployeeModel.getId() );
        restaurantEmployeeFeignDto.setRestaurant( restaurantModelToRestaurantFeignDto( restaurantEmployeeModel.getRestaurant() ) );
        restaurantEmployeeFeignDto.setUserId( restaurantEmployeeModel.getUserId() );

        return restaurantEmployeeFeignDto;
    }

    protected RestaurantFeignDto restaurantModelToRestaurantFeignDto(RestaurantModel restaurantModel) {
        if ( restaurantModel == null ) {
            return null;
        }

        RestaurantFeignDto restaurantFeignDto = new RestaurantFeignDto();

        restaurantFeignDto.setId( restaurantModel.getId() );
        restaurantFeignDto.setName( restaurantModel.getName() );
        restaurantFeignDto.setNit( restaurantModel.getNit() );
        restaurantFeignDto.setAddress( restaurantModel.getAddress() );
        restaurantFeignDto.setPhone( restaurantModel.getPhone() );
        restaurantFeignDto.setUrlLogo( restaurantModel.getUrlLogo() );
        restaurantFeignDto.setOwnerId( restaurantModel.getOwnerId() );

        return restaurantFeignDto;
    }
}
