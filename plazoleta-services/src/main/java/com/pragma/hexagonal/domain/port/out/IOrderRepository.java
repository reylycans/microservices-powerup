package com.pragma.hexagonal.domain.port.out;
import com.pragma.hexagonal.domain.model.OrderModel;

import java.util.List;

public interface IOrderRepository {
    void save(OrderModel orderModel);
    List<OrderModel> getAllOrderWithPagination(Integer page, Integer size, String state);
    void takeOrderForEmployee(Long orderId);
    void notifyOrderReady(Long orderId);
    void cancelOrder(Long orderId);
    void deliverOrder(Long orderId,String pin);
}
