package com.pragma.usuarios.infraestructure.port.out.feignclients.mapper;

import com.pragma.usuarios.domain.model.RestaurantModel;
import com.pragma.usuarios.infraestructure.port.out.feignclients.dto.RestaurantFeignDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-30T15:45:48-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IRestaurantFeignMapperImpl implements IRestaurantFeignMapper {

    @Override
    public RestaurantModel toModel(RestaurantFeignDto restaurantFeignDto) {
        if ( restaurantFeignDto == null ) {
            return null;
        }

        RestaurantModel restaurantModel = new RestaurantModel();

        restaurantModel.setId( restaurantFeignDto.getId() );
        restaurantModel.setName( restaurantFeignDto.getName() );
        restaurantModel.setNit( restaurantFeignDto.getNit() );
        restaurantModel.setAddress( restaurantFeignDto.getAddress() );
        restaurantModel.setPhone( restaurantFeignDto.getPhone() );
        restaurantModel.setUrlLogo( restaurantFeignDto.getUrlLogo() );
        restaurantModel.setOwnerId( restaurantFeignDto.getOwnerId() );

        return restaurantModel;
    }
}
