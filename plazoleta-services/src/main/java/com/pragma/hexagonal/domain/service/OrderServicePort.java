package com.pragma.hexagonal.domain.service;

import com.pragma.hexagonal.domain.enums.MessageErrorEnum;
import com.pragma.hexagonal.domain.enums.StateEnum;
import com.pragma.hexagonal.domain.exception.OrderDomainException;
import com.pragma.hexagonal.domain.model.OrderModel;
import com.pragma.hexagonal.domain.model.RestaurantEmployeeModel;
import com.pragma.hexagonal.domain.port.in.IOrderServicePort;
import com.pragma.hexagonal.domain.port.out.IOrderRepository;
import com.pragma.hexagonal.domain.port.out.IRestaurantEmployeeRepository;
import com.pragma.hexagonal.domain.port.out.IToken;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class OrderServicePort implements IOrderServicePort {

    private final IOrderRepository orderRepository;
    private final IToken token;
    private final IRestaurantEmployeeRepository restaurantEmployeeRepository;

    public OrderServicePort(IOrderRepository orderRepository,IToken token,
                            IRestaurantEmployeeRepository restaurantEmployeeRepository) {
        this.orderRepository = orderRepository;
        this.token = token;
        this.restaurantEmployeeRepository = restaurantEmployeeRepository;
    }

    @Override
    public void save(OrderModel orderModel) {
       List<String> states = List.of(StateEnum.PENDING.toString(),
                                     StateEnum.READY.toString(),StateEnum.PREPARATION.toString());
       if(orderRepository.existOrderBYCustomerAndState(orderModel.getCustomerId(),states))
          throw new OrderDomainException(MessageErrorEnum.ORDER_SAVE.getValue());

       orderModel.setState(StateEnum.PENDING.toString());
       orderModel.setCreateAt(LocalDate.now());
       orderRepository.save(orderModel);
    }

    @Override
    public List<OrderModel> getAllOrderWithPagination(Integer page, Integer size, String state) {
        Long employeeAuth = token.getUserAuthenticateId(token.getBearerToken());
        Optional<RestaurantEmployeeModel> restaurantEmployeeModel = restaurantEmployeeRepository.getRestaurantEmployeeById(employeeAuth);
        if(!restaurantEmployeeModel.isPresent()) throw new OrderDomainException(MessageErrorEnum.ORDER_RESTAURANT_EMPLOYE_NOT_EXIST.getValue());
        List<OrderModel> orderModelList = orderRepository.getAllOrderWithPagination(restaurantEmployeeModel.get().getRestaurant().getId(),
                                                                                    employeeAuth,page,size,state);
        if(orderModelList.isEmpty()) throw new OrderDomainException(MessageErrorEnum.ORDER_NOT_FOUND.getValue());

        return orderModelList;
    }

    @Override
    public void takeOrderForEmployee(Long orderId,String state) {
        if(!state.equals(StateEnum.PREPARATION.toString())) throw new OrderDomainException(MessageErrorEnum.ORDER_STATUS_CANNOT_DIFFERENT.getValue());

        Long employeeAuth = token.getUserAuthenticateId(token.getBearerToken());
        Optional<RestaurantEmployeeModel> restaurantEmployeeModel = restaurantEmployeeRepository.getRestaurantEmployeeById(employeeAuth);
        if(!restaurantEmployeeModel.isPresent()) throw new OrderDomainException(MessageErrorEnum.ORDER_RESTAURANT_EMPLOYE_NOT_EXIST.getValue());

        Optional<OrderModel> orderModel = orderRepository.findOrderByIdAndState(orderId, StateEnum.PENDING.toString());
        if(!orderModel.isPresent()) throw new OrderDomainException(MessageErrorEnum.ORDER_NO_FOUND_IN_PENDING_STATUS.getValue());

        if(!restaurantEmployeeModel.get().getRestaurant().getId().equals(orderModel.get().getRestaurant().getId()))
            throw new OrderDomainException(MessageErrorEnum.ORDER_EMPLOYEE_NOT_MATCH_RESTAURANT.getValue());

        orderModel.get().setRestaurantEmployee(restaurantEmployeeModel.get());
        orderModel.get().setState(StateEnum.PREPARATION.toString());
        orderRepository.save(orderModel.get());

    }

    @Override
    public void notifyOrderReady(Long orderId) {
        
    }

    @Override
    public void cancelOrder(Long orderId) {

    }

    @Override
    public void deliverOrder(Long orderId, String pin) {

    }
}
