package com.pragma.hexagonal.infraestructure.port.out.mapper;

import com.pragma.hexagonal.domain.model.CategoryModel;
import com.pragma.hexagonal.domain.model.DishModel;
import com.pragma.hexagonal.domain.model.OrderDetailModel;
import com.pragma.hexagonal.domain.model.OrderModel;
import com.pragma.hexagonal.domain.model.RestaurantEmployeeModel;
import com.pragma.hexagonal.domain.model.RestaurantModel;
import com.pragma.hexagonal.infraestructure.port.out.entity.CategoryEntity;
import com.pragma.hexagonal.infraestructure.port.out.entity.DishEntity;
import com.pragma.hexagonal.infraestructure.port.out.entity.OrderDetailEntity;
import com.pragma.hexagonal.infraestructure.port.out.entity.OrderEntity;
import com.pragma.hexagonal.infraestructure.port.out.entity.RestaurantEmployeeEntity;
import com.pragma.hexagonal.infraestructure.port.out.entity.RestaurantEntity;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-14T15:46:35-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IOrderEntityMapperImpl implements IOrderEntityMapper {

    @Override
    public OrderEntity toEntity(OrderModel orderModel) {
        if ( orderModel == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setId( orderModel.getId() );
        orderEntity.setCustomerId( orderModel.getCustomerId() );
        orderEntity.setCreateAt( orderModel.getCreateAt() );
        orderEntity.setState( orderModel.getState() );
        orderEntity.setRestaurant( restaurantModelToRestaurantEntity( orderModel.getRestaurant() ) );
        orderEntity.setRestaurantEmployee( restaurantEmployeeModelToRestaurantEmployeeEntity( orderModel.getRestaurantEmployee() ) );
        orderEntity.setDishes( orderDetailModelSetToOrderDetailEntitySet( orderModel.getDishes() ) );

        return orderEntity;
    }

    @Override
    public OrderModel toModel(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        OrderModel orderModel = new OrderModel();

        orderModel.setId( orderEntity.getId() );
        orderModel.setCustomerId( orderEntity.getCustomerId() );
        orderModel.setCreateAt( orderEntity.getCreateAt() );
        orderModel.setState( orderEntity.getState() );
        orderModel.setRestaurant( restaurantEntityToRestaurantModel( orderEntity.getRestaurant() ) );
        orderModel.setDishes( orderDetailEntitySetToOrderDetailModelSet( orderEntity.getDishes() ) );
        orderModel.setRestaurantEmployee( restaurantEmployeeEntityToRestaurantEmployeeModel( orderEntity.getRestaurantEmployee() ) );

        return orderModel;
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

    protected RestaurantEmployeeEntity restaurantEmployeeModelToRestaurantEmployeeEntity(RestaurantEmployeeModel restaurantEmployeeModel) {
        if ( restaurantEmployeeModel == null ) {
            return null;
        }

        RestaurantEmployeeEntity restaurantEmployeeEntity = new RestaurantEmployeeEntity();

        restaurantEmployeeEntity.setId( restaurantEmployeeModel.getId() );
        restaurantEmployeeEntity.setRestaurant( restaurantModelToRestaurantEntity( restaurantEmployeeModel.getRestaurant() ) );
        restaurantEmployeeEntity.setUserId( restaurantEmployeeModel.getUserId() );

        return restaurantEmployeeEntity;
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

    protected DishEntity dishModelToDishEntity(DishModel dishModel) {
        if ( dishModel == null ) {
            return null;
        }

        DishEntity dishEntity = new DishEntity();

        dishEntity.setId( dishModel.getId() );
        dishEntity.setName( dishModel.getName() );
        dishEntity.setPrice( dishModel.getPrice() );
        dishEntity.setDescription( dishModel.getDescription() );
        dishEntity.setUrlImage( dishModel.getUrlImage() );
        dishEntity.setAsset( dishModel.getAsset() );
        dishEntity.setRestaurant( restaurantModelToRestaurantEntity( dishModel.getRestaurant() ) );
        dishEntity.setCategory( categoryModelToCategoryEntity( dishModel.getCategory() ) );

        return dishEntity;
    }

    protected OrderDetailEntity orderDetailModelToOrderDetailEntity(OrderDetailModel orderDetailModel) {
        if ( orderDetailModel == null ) {
            return null;
        }

        OrderDetailEntity orderDetailEntity = new OrderDetailEntity();

        orderDetailEntity.setId( orderDetailModel.getId() );
        orderDetailEntity.setDish( dishModelToDishEntity( orderDetailModel.getDish() ) );
        orderDetailEntity.setAmount( orderDetailModel.getAmount() );

        return orderDetailEntity;
    }

    protected Set<OrderDetailEntity> orderDetailModelSetToOrderDetailEntitySet(Set<OrderDetailModel> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrderDetailEntity> set1 = new LinkedHashSet<OrderDetailEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrderDetailModel orderDetailModel : set ) {
            set1.add( orderDetailModelToOrderDetailEntity( orderDetailModel ) );
        }

        return set1;
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

    protected DishModel dishEntityToDishModel(DishEntity dishEntity) {
        if ( dishEntity == null ) {
            return null;
        }

        DishModel dishModel = new DishModel();

        dishModel.setId( dishEntity.getId() );
        dishModel.setName( dishEntity.getName() );
        dishModel.setPrice( dishEntity.getPrice() );
        dishModel.setDescription( dishEntity.getDescription() );
        dishModel.setUrlImage( dishEntity.getUrlImage() );
        dishModel.setCategory( categoryEntityToCategoryModel( dishEntity.getCategory() ) );
        dishModel.setRestaurant( restaurantEntityToRestaurantModel( dishEntity.getRestaurant() ) );
        dishModel.setAsset( dishEntity.getAsset() );

        return dishModel;
    }

    protected OrderDetailModel orderDetailEntityToOrderDetailModel(OrderDetailEntity orderDetailEntity) {
        if ( orderDetailEntity == null ) {
            return null;
        }

        OrderDetailModel orderDetailModel = new OrderDetailModel();

        orderDetailModel.setId( orderDetailEntity.getId() );
        orderDetailModel.setDish( dishEntityToDishModel( orderDetailEntity.getDish() ) );
        orderDetailModel.setAmount( orderDetailEntity.getAmount() );

        return orderDetailModel;
    }

    protected Set<OrderDetailModel> orderDetailEntitySetToOrderDetailModelSet(Set<OrderDetailEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrderDetailModel> set1 = new LinkedHashSet<OrderDetailModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrderDetailEntity orderDetailEntity : set ) {
            set1.add( orderDetailEntityToOrderDetailModel( orderDetailEntity ) );
        }

        return set1;
    }

    protected RestaurantEmployeeModel restaurantEmployeeEntityToRestaurantEmployeeModel(RestaurantEmployeeEntity restaurantEmployeeEntity) {
        if ( restaurantEmployeeEntity == null ) {
            return null;
        }

        RestaurantEmployeeModel restaurantEmployeeModel = new RestaurantEmployeeModel();

        restaurantEmployeeModel.setId( restaurantEmployeeEntity.getId() );
        restaurantEmployeeModel.setRestaurant( restaurantEntityToRestaurantModel( restaurantEmployeeEntity.getRestaurant() ) );
        restaurantEmployeeModel.setUserId( restaurantEmployeeEntity.getUserId() );

        return restaurantEmployeeModel;
    }
}
