package com.pragma.hexagonal.domain.service;

import com.pragma.hexagonal.domain.enums.MessageErrorEnum;
import com.pragma.hexagonal.domain.enums.StateEnum;
import com.pragma.hexagonal.domain.exception.OrderDomainException;
import com.pragma.hexagonal.domain.model.MessageModel;
import com.pragma.hexagonal.domain.model.OrderModel;
import com.pragma.hexagonal.domain.model.RestaurantEmployeeModel;
import com.pragma.hexagonal.domain.port.in.IOrderServicePort;
import com.pragma.hexagonal.domain.port.out.IOrderRepository;
import com.pragma.hexagonal.domain.port.out.IRestaurantEmployeeRepository;
import com.pragma.hexagonal.domain.port.out.IToken;
import com.pragma.hexagonal.domain.port.out.feignclients.ITwilioFeignClientRepository;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class OrderServicePort implements IOrderServicePort {
    @Value("${phoneNumber}")
    private String phoneNumber;
    @Value("${message}")
    private String message;
    @Value("${canceledOrderMessage}")
    private String canceledOrderMessage;

    private final IOrderRepository orderRepository;
    private final IToken token;
    private final IRestaurantEmployeeRepository restaurantEmployeeRepository;
    private final ITwilioFeignClientRepository twilioFeignClientRepository;

    public OrderServicePort(IOrderRepository orderRepository,IToken token,
                            IRestaurantEmployeeRepository restaurantEmployeeRepository,
                            ITwilioFeignClientRepository twilioFeignClientRepository) {
        this.orderRepository = orderRepository;
        this.token = token;
        this.restaurantEmployeeRepository = restaurantEmployeeRepository;
        this.twilioFeignClientRepository = twilioFeignClientRepository;
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
        OrderModel orderModel = orderValidate(orderId,state,Boolean.FALSE);
        orderModel.setState(StateEnum.PREPARATION.toString());
        orderRepository.save(orderModel);
    }

    private OrderModel orderValidate(Long orderId,String state,Boolean delivery){
        if(state!=null && !state.equals(StateEnum.PREPARATION.toString())) throw new OrderDomainException(MessageErrorEnum.ORDER_STATUS_CANNOT_DIFFERENT.getValue());

        Long employeeAuth = token.getUserAuthenticateId(token.getBearerToken());
        Optional<RestaurantEmployeeModel> restaurantEmployeeModel = restaurantEmployeeRepository.getRestaurantEmployeeById(employeeAuth);
        if(!restaurantEmployeeModel.isPresent()) throw new OrderDomainException(MessageErrorEnum.ORDER_RESTAURANT_EMPLOYE_NOT_EXIST.getValue());

        Optional<OrderModel> orderModel = orderRepository.findOrderByIdAndState(orderId,validateStatus(state,delivery));
        if(!orderModel.isPresent()) throw new OrderDomainException(MessageErrorEnum.ORDER_NO_FOUND_IN_PENDING_STATUS.getValue());

        if(!restaurantEmployeeModel.get().getRestaurant().getId().equals(orderModel.get().getRestaurant().getId()))
            throw new OrderDomainException(MessageErrorEnum.ORDER_EMPLOYEE_NOT_MATCH_RESTAURANT.getValue());

        orderModel.get().setRestaurantEmployee(restaurantEmployeeModel.get());
        return orderModel.get();
    }

    private String validateStatus(String state,Boolean delivery){
        String status;
        if(state!=null && Boolean.FALSE.equals(delivery)){
            status = StateEnum.PENDING.toString();
        } else if (state==null && Boolean.FALSE.equals(delivery)) {
            status = StateEnum.PREPARATION.toString();
        }else {
            status = StateEnum.READY.toString();
        }
        return status;
    }

    @Override
    public void notifyOrderReady(Long orderId) {
        OrderModel orderModel = orderValidate(orderId,null,Boolean.FALSE);
        orderModel.setState(StateEnum.READY.toString());
        orderRepository.save(orderModel);
        String pin = validatePin(orderModel);
        twilioFeignClientRepository.sendMessageTwilio(MessageModel.builder().number(phoneNumber).message(message + pin).build());
    }

    private String validatePin(OrderModel orderModel){
        StringBuilder builder = new StringBuilder(orderModel.getId().toString())
                                                            .append(orderModel.getCustomerId())
                                                            .append(orderModel.getRestaurant().getId())
                                                            .append(orderModel.getCreateAt());
        return builder.toString();
    }

    @Override
    public void deliverOrder(Long orderId, String pin) {
        OrderModel orderModel = orderValidate(orderId,null,Boolean.TRUE);
        if(!validatePin(orderModel).equals(pin)) throw new OrderDomainException(MessageErrorEnum.ORDER_INVALID_PIN.getValue());
        orderModel.setState(StateEnum.DELIVERED.toString());
        orderRepository.save(orderModel);
    }

    @Override
    public void cancelOrder(Long orderId) {
        Optional<OrderModel> orderModel = orderRepository.findOrderByIdAndState(orderId,StateEnum.PENDING.toString());
        if(!orderModel.isPresent()){
            twilioFeignClientRepository.sendMessageTwilio(MessageModel.builder().number(phoneNumber).message(canceledOrderMessage).build());
            throw new OrderDomainException(MessageErrorEnum.ORDER_CANCELED_MESSAGE.getValue());
        }

        orderModel.get().setState(StateEnum.CANCELED.toString());
        orderRepository.save(orderModel.get());
    }


}
