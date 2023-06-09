package com.pragma.hexagonal.application.handler.impl;

import com.pragma.hexagonal.application.dto.request.OrderRequestDto;
import com.pragma.hexagonal.application.dto.response.OrderResponseDto;
import com.pragma.hexagonal.application.handler.IOrderHandler;
import com.pragma.hexagonal.application.mapper.request.IOrderRequestMapper;
import com.pragma.hexagonal.application.mapper.response.IOrderResponseMapper;
import com.pragma.hexagonal.domain.model.OrderModel;
import com.pragma.hexagonal.domain.port.in.IOrderServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderHandler implements IOrderHandler {

    private final IOrderServicePort orderServicePort;
    private final IOrderRequestMapper orderRequestMapper;
    private final IOrderResponseMapper orderResponseMapper;

    @Override
    @Transactional
    public void save(OrderRequestDto orderRequestDto) {
        OrderModel orderModel = orderRequestMapper.toOrder(orderRequestDto);
        orderServicePort.save(orderModel);
    }

    @Override
    public List<OrderResponseDto> getAllOrderWithPagination(Integer page, Integer size, String state) {
        return orderResponseMapper.toResponseList(orderServicePort.getAllOrderWithPagination(page,size,state));
    }

    @Override
    @Transactional
    public void takeOrderForEmployee(Long orderId,String state) {
       orderServicePort.takeOrderForEmployee(orderId,state);
    }

    @Override
    @Transactional
    public void notifyOrderReady(Long orderId) {
        orderServicePort.notifyOrderReady(orderId);
    }

    @Override
    public void cancelOrder(Long orderId) {
       orderServicePort.cancelOrder(orderId);
    }

    @Override
    public void deliverOrder(Long orderId, String pin) {
        orderServicePort.deliverOrder(orderId,pin);
    }
}
