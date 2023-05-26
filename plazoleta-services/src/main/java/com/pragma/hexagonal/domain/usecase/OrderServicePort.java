package com.pragma.hexagonal.domain.usecase;

import com.pragma.hexagonal.domain.model.OrderModel;
import com.pragma.hexagonal.domain.port.in.IOrderServicePort;
import com.pragma.hexagonal.domain.port.out.IOrderRepository;

import java.util.List;

public class OrderServicePort implements IOrderServicePort {

    private final IOrderRepository orderRepository;

    public OrderServicePort(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void save(OrderModel orderModel) {

    }

    @Override
    public List<OrderModel> getAllOrderWithPagination(Integer page, Integer size, String state) {
        return null;
    }

    @Override
    public void takeOrderForEmployee(Long orderId) {

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
