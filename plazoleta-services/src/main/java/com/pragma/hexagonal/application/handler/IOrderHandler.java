package com.pragma.hexagonal.application.handler;
import com.pragma.hexagonal.application.dto.request.OrderRequestDto;
import com.pragma.hexagonal.application.dto.response.OrderResponseDto;

import java.util.List;

public interface IOrderHandler {
    void save(OrderRequestDto orderRequestDto);
    List<OrderResponseDto> getAllOrderWithPagination(Integer page,Integer size,String state);
    void takeOrderForEmployee(Long orderId,String state);
    void notifyOrderReady(Long orderId);
    void cancelOrder(Long orderId);
    void deliverOrder(Long orderId,String pin);


}
