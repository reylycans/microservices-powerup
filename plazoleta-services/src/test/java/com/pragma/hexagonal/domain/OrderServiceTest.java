package com.pragma.hexagonal.domain;

import com.pragma.hexagonal.domain.enums.StateEnum;
import com.pragma.hexagonal.domain.exception.OrderDomainException;
import com.pragma.hexagonal.domain.model.OrderModel;
import com.pragma.hexagonal.domain.port.out.IOrderRepository;
import com.pragma.hexagonal.domain.port.out.IRestaurantEmployeeRepository;
import com.pragma.hexagonal.domain.port.out.IToken;
import com.pragma.hexagonal.domain.service.OrderServicePort;
import com.pragma.hexagonal.factory.OrderFactoryDataTest;
import com.pragma.hexagonal.factory.RestaurantFactoryDataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
public class OrderServiceTest {

    @InjectMocks
    OrderServicePort orderServicePort;
    @Mock
    IOrderRepository orderRepository;
    @Mock
    IToken token;
    @Mock
    IRestaurantEmployeeRepository restaurantEmployeeRepository;


    @Test
    public void saveOrder(){
        OrderModel orderModel = OrderFactoryDataTest.getOrder();
        Mockito.when(orderRepository.existOrderBYCustomerAndState(orderModel.getCustomerId(),
                                                            OrderFactoryDataTest.OrderStatus())).thenReturn(Boolean.FALSE);

        orderServicePort.save(orderModel);
        Mockito.verify(orderRepository).save(orderModel);
    }

    @Test
    public void existingOrderStatusPending(){
        OrderModel orderModel = OrderFactoryDataTest.getOrder();
        Mockito.when(orderRepository.existOrderBYCustomerAndState(orderModel.getCustomerId(),
                OrderFactoryDataTest.OrderStatus())).thenReturn(Boolean.TRUE);

        assertThrows(OrderDomainException.class,()->orderServicePort.save(orderModel));
    }

    @Test
    public void allOrderWithPagination(){
        Mockito.when(token.getBearerToken()).thenReturn("validToken");
        Mockito.when(token.getUserAuthenticateId("validToken")).thenReturn(23L);

        Mockito.when(restaurantEmployeeRepository.getRestaurantEmployeeById(23L)).
                                                 thenReturn(RestaurantFactoryDataTest.getRestaurantEmployee());

        Mockito.when(orderRepository.getAllOrderWithPagination(1L,23L,0,1, StateEnum.PENDING.toString()))
                .thenReturn(OrderFactoryDataTest.getOrderList());

        orderServicePort.getAllOrderWithPagination(0,1,StateEnum.PENDING.toString());
        Mockito.verify(orderRepository).getAllOrderWithPagination(1L,23L,0,1, StateEnum.PENDING.toString());

    }
    @Test
    public void orderNoFoundInPendingStatus(){
        Mockito.when(token.getBearerToken()).thenReturn("validToken");
        Mockito.when(token.getUserAuthenticateId("validToken")).thenReturn(23L);

        Mockito.when(restaurantEmployeeRepository.getRestaurantEmployeeById(23L)).
                thenReturn(RestaurantFactoryDataTest.getRestaurantEmployee());

        assertThrows(OrderDomainException.class,()->orderServicePort.takeOrderForEmployee(1L,StateEnum.PREPARATION.toString()));

    }


}
