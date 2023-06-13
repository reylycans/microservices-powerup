package com.pragma.hexagonal.domain.port.out;
import com.pragma.hexagonal.domain.model.OrderModel;

import java.util.List;
import java.util.Optional;

public interface IOrderRepository {
    void save(OrderModel orderModel);
    List<OrderModel> getAllOrderWithPagination(Long restaurantId,Long employeeId,Integer page, Integer size, String state);
    Boolean existOrderBYCustomerAndState(Long customerId, List<String> state);
    Optional<OrderModel> findOrderByIdAndState(Long orderId, String state);
    void notifyOrderReady(Long orderId);
    void cancelOrder(Long orderId);
    void deliverOrder(Long orderId,String pin);
}
