package com.pragma.hexagonal.application.mapper.response;

import com.pragma.hexagonal.application.dto.response.OrderResponseDto;
import com.pragma.hexagonal.domain.model.OrderDetails;
import com.pragma.hexagonal.domain.model.OrderModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-08T09:23:05-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class IOrderResponseMapperImpl implements IOrderResponseMapper {

    @Override
    public OrderResponseDto toResponse(OrderModel orderModel) {
        if ( orderModel == null ) {
            return null;
        }

        OrderResponseDto orderResponseDto = new OrderResponseDto();

        orderResponseDto.setId( orderModel.getId() );
        orderResponseDto.setCustomerId( orderModel.getCustomerId() );
        orderResponseDto.setCreateAt( orderModel.getCreateAt() );
        orderResponseDto.setState( orderModel.getState() );
        orderResponseDto.setRestaurant( orderModel.getRestaurant() );
        List<OrderDetails> list = orderModel.getDish();
        if ( list != null ) {
            orderResponseDto.setDish( new ArrayList<OrderDetails>( list ) );
        }

        return orderResponseDto;
    }

    @Override
    public List<OrderResponseDto> toResponseList(List<OrderModel> orderModels) {
        if ( orderModels == null ) {
            return null;
        }

        List<OrderResponseDto> list = new ArrayList<OrderResponseDto>( orderModels.size() );
        for ( OrderModel orderModel : orderModels ) {
            list.add( toResponse( orderModel ) );
        }

        return list;
    }
}
