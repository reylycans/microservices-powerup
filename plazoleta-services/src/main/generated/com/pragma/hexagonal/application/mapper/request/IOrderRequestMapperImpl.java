package com.pragma.hexagonal.application.mapper.request;

import com.pragma.hexagonal.application.dto.request.OrderDetailsRequestDto;
import com.pragma.hexagonal.application.dto.request.OrderRequestDto;
import com.pragma.hexagonal.application.dto.request.RestaurantRequestDto;
import com.pragma.hexagonal.domain.model.OrderDetails;
import com.pragma.hexagonal.domain.model.OrderModel;
import com.pragma.hexagonal.domain.model.RestaurantModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-08T09:23:07-0500",
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
        orderModel.setDish( orderDetailsRequestDtoListToOrderDetailsList( orderRequestDto.getDish() ) );

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

    protected OrderDetails orderDetailsRequestDtoToOrderDetails(OrderDetailsRequestDto orderDetailsRequestDto) {
        if ( orderDetailsRequestDto == null ) {
            return null;
        }

        OrderDetails orderDetails = new OrderDetails();

        orderDetails.setId( orderDetailsRequestDto.getId() );
        orderDetails.setAmount( orderDetailsRequestDto.getAmount() );

        return orderDetails;
    }

    protected List<OrderDetails> orderDetailsRequestDtoListToOrderDetailsList(List<OrderDetailsRequestDto> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderDetails> list1 = new ArrayList<OrderDetails>( list.size() );
        for ( OrderDetailsRequestDto orderDetailsRequestDto : list ) {
            list1.add( orderDetailsRequestDtoToOrderDetails( orderDetailsRequestDto ) );
        }

        return list1;
    }
}
