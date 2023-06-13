package com.pragma.hexagonal.domain.port.in;
import com.pragma.hexagonal.domain.model.OrderModel;

import java.util.List;

public interface IOrderServicePort {
    void save(OrderModel orderModel);
    List<OrderModel> getAllOrderWithPagination(Integer page, Integer size, String state);
    void takeOrderForEmployee(Long orderId,String state);
    void notifyOrderReady(Long orderId);
    void cancelOrder(Long orderId);
    void deliverOrder(Long orderId,String pin);
}
