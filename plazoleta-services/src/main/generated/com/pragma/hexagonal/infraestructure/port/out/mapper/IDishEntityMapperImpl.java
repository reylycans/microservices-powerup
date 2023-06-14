package com.pragma.hexagonal.infraestructure.port.out.mapper;

import com.pragma.hexagonal.domain.model.CategoryModel;
import com.pragma.hexagonal.domain.model.DishModel;
import com.pragma.hexagonal.domain.model.RestaurantModel;
import com.pragma.hexagonal.infraestructure.port.out.entity.CategoryEntity;
import com.pragma.hexagonal.infraestructure.port.out.entity.DishEntity;
import com.pragma.hexagonal.infraestructure.port.out.entity.RestaurantEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-14T15:46:35-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IDishEntityMapperImpl implements IDishEntityMapper {

    @Override
    public DishEntity toEntity(DishModel dishModel) {
        if ( dishModel == null ) {
            return null;
        }

        DishEntity dishEntity = new DishEntity();

        dishEntity.setCategory( categoryModelToCategoryEntity( dishModel.getCategory() ) );
        dishEntity.setId( dishModel.getId() );
        dishEntity.setName( dishModel.getName() );
        dishEntity.setPrice( dishModel.getPrice() );
        dishEntity.setDescription( dishModel.getDescription() );
        dishEntity.setUrlImage( dishModel.getUrlImage() );
        dishEntity.setAsset( dishModel.getAsset() );
        dishEntity.setRestaurant( restaurantModelToRestaurantEntity( dishModel.getRestaurant() ) );

        return dishEntity;
    }

    @Override
    public DishModel toModel(DishEntity dishEntity) {
        if ( dishEntity == null ) {
            return null;
        }

        DishModel dishModel = new DishModel();

        dishModel.setCategory( categoryEntityToCategoryModel( dishEntity.getCategory() ) );
        dishModel.setId( dishEntity.getId() );
        dishModel.setName( dishEntity.getName() );
        dishModel.setPrice( dishEntity.getPrice() );
        dishModel.setDescription( dishEntity.getDescription() );
        dishModel.setUrlImage( dishEntity.getUrlImage() );
        dishModel.setRestaurant( restaurantEntityToRestaurantModel( dishEntity.getRestaurant() ) );
        dishModel.setAsset( dishEntity.getAsset() );

        return dishModel;
    }

    protected CategoryEntity categoryModelToCategoryEntity(CategoryModel categoryModel) {
        if ( categoryModel == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( categoryModel.getId() );
        categoryEntity.setName( categoryModel.getName() );
        categoryEntity.setDescription( categoryModel.getDescription() );

        return categoryEntity;
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

    protected CategoryModel categoryEntityToCategoryModel(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        CategoryModel categoryModel = new CategoryModel();

        categoryModel.setId( categoryEntity.getId() );
        categoryModel.setName( categoryEntity.getName() );
        categoryModel.setDescription( categoryEntity.getDescription() );

        return categoryModel;
    }

    protected RestaurantModel restaurantEntityToRestaurantModel(RestaurantEntity restaurantEntity) {
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
}
