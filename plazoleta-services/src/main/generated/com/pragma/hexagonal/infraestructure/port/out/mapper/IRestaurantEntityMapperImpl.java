package com.pragma.hexagonal.infraestructure.port.out.mapper;

import com.pragma.hexagonal.domain.model.RestaurantModel;
import com.pragma.hexagonal.infraestructure.port.out.entity.RestaurantEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-30T15:54:49-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IRestaurantEntityMapperImpl implements IRestaurantEntityMapper {

    @Override
    public RestaurantEntity toEntity(RestaurantModel restaurantModel) {
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

    @Override
    public RestaurantModel toModel(RestaurantEntity restaurantEntity) {
        if ( restaurantEntity == null ) {
            return null;
        }

        RestaurantModel restaurantModel = new RestaurantModel();

        restaurantModel.setId( restaurantEntity.getId() );
        restaurantModel.setName( restaurantEntity.getName() );
        restaurantModel.setNit( restaurantEntity.getNit() );
        restaurantModel.setAddress( restaurantEntity.getAddress() );
        restaurantModel.setPhone( restaurantEntity.getPhone() );
        restaurantModel.setUrlLogo( restaurantEntity.getUrlLogo() );
        restaurantModel.setOwnerId( restaurantEntity.getOwnerId() );

        return restaurantModel;
    }

    @Override
    public List<RestaurantModel> toModelList(List<RestaurantEntity> restaurantEntities) {
        if ( restaurantEntities == null ) {
            return null;
        }

        List<RestaurantModel> list = new ArrayList<RestaurantModel>( restaurantEntities.size() );
        for ( RestaurantEntity restaurantEntity : restaurantEntities ) {
            list.add( toModel( restaurantEntity ) );
        }

        return list;
    }
}
