package com.pragma.hexagonal.application.mapper.request;

import com.pragma.hexagonal.application.dto.request.CategoryRequestDto;
import com.pragma.hexagonal.application.dto.request.DishRequestDto;
import com.pragma.hexagonal.application.dto.request.OrderDetailsRequestDto;
import com.pragma.hexagonal.application.dto.request.OrderRequestDto;
import com.pragma.hexagonal.application.dto.request.RestaurantRequestDto;
import com.pragma.hexagonal.domain.model.CategoryModel;
import com.pragma.hexagonal.domain.model.DishModel;
import com.pragma.hexagonal.domain.model.OrderDetails;
import com.pragma.hexagonal.domain.model.OrderModel;
import com.pragma.hexagonal.domain.model.RestaurantModel;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-13T12:49:05-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IOrderRequestMapperImpl implements IOrderRequestMapper {

    @Override
    public OrderModel toOrder(OrderRequestDto orderRequestDto) {
        if ( orderRequestDto == null ) {
            return null;
        }

        OrderModel orderModel = new OrderModel();

        orderModel.setId( orderRequestDto.getId() );
        orderModel.setCustomerId( orderRequestDto.getCustomerId() );
        orderModel.setCreateAt( orderRequestDto.getCreateAt() );
        orderModel.setState( orderRequestDto.getState() );
        orderModel.setRestaurant( restaurantRequestDtoToRestaurantModel( orderRequestDto.getRestaurant() ) );
        orderModel.setDishes( orderDetailsRequestDtoSetToOrderDetailsSet( orderRequestDto.getDishes() ) );

        return orderModel;
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

    protected DishModel dishRequestDtoToDishModel(DishRequestDto dishRequestDto) {
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

    protected OrderDetails orderDetailsRequestDtoToOrderDetails(OrderDetailsRequestDto orderDetailsRequestDto) {
        if ( orderDetailsRequestDto == null ) {
            return null;
        }

        OrderDetails orderDetails = new OrderDetails();

        orderDetails.setId( orderDetailsRequestDto.getId() );
        orderDetails.setDish( dishRequestDtoToDishModel( orderDetailsRequestDto.getDish() ) );
        orderDetails.setAmount( orderDetailsRequestDto.getAmount() );

        return orderDetails;
    }

    protected Set<OrderDetails> orderDetailsRequestDtoSetToOrderDetailsSet(Set<OrderDetailsRequestDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrderDetails> set1 = new LinkedHashSet<OrderDetails>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrderDetailsRequestDto orderDetailsRequestDto : set ) {
            set1.add( orderDetailsRequestDtoToOrderDetails( orderDetailsRequestDto ) );
        }

        return set1;
    }
}
