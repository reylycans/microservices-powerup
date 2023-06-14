package com.pragma.hexagonal.application.mapper.request;

import com.pragma.hexagonal.application.dto.request.CategoryRequestDto;
import com.pragma.hexagonal.application.dto.request.DishRequestDto;
import com.pragma.hexagonal.application.dto.request.RestaurantRequestDto;
import com.pragma.hexagonal.domain.model.CategoryModel;
import com.pragma.hexagonal.domain.model.DishModel;
import com.pragma.hexagonal.domain.model.RestaurantModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-14T15:46:35-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IDishRequestMapperImpl implements IDishRequestMapper {

    @Override
    public DishModel toModel(DishRequestDto dishRequestDto) {
        if ( dishRequestDto == null ) {
            return null;
        }

        DishModel dishModel = new DishModel();

        dishModel.setId( dishRequestDto.getId() );
        dishModel.setName( dishRequestDto.getName() );
        dishModel.setPrice( dishRequestDto.getPrice() );
        dishModel.setDescription( dishRequestDto.getDescription() );
        dishModel.setUrlImage( dishRequestDto.getUrlImage() );
        dishModel.setCategory( categoryRequestDtoToCategoryModel( dishRequestDto.getCategory() ) );
        dishModel.setRestaurant( restaurantRequestDtoToRestaurantModel( dishRequestDto.getRestaurant() ) );

        return dishModel;
    }

    protected CategoryModel categoryRequestDtoToCategoryModel(CategoryRequestDto categoryRequestDto) {
        if ( categoryRequestDto == null ) {
            return null;
        }

        CategoryModel categoryModel = new CategoryModel();

        categoryModel.setId( categoryRequestDto.getId() );
        categoryModel.setName( categoryRequestDto.getName() );
        categoryModel.setDescription( categoryRequestDto.getDescription() );

        return categoryModel;
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
