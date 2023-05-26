package com.pragma.hexagonal.infraestructure.port.out.adapter;

import com.pragma.hexagonal.domain.model.OrderModel;
import com.pragma.hexagonal.domain.port.out.IOrderRepository;

import java.util.List;

public class OrderRepository implements IOrderRepository {

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
