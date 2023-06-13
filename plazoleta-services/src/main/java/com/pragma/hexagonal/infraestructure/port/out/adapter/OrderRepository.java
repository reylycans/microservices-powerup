package com.pragma.hexagonal.infraestructure.port.out.adapter;


import com.pragma.hexagonal.domain.model.OrderModel;
import com.pragma.hexagonal.domain.port.out.IOrderRepository;
import com.pragma.hexagonal.infraestructure.port.out.entity.OrderEntity;
import com.pragma.hexagonal.infraestructure.port.out.mapper.IOrderEntityMapper;
import com.pragma.hexagonal.infraestructure.port.out.repository.IOrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class OrderRepository implements IOrderRepository {

    private final IOrderJpaRepository orderJpaRepository;
    private final IOrderEntityMapper orderEntityMapper;

    @Override
    public void save(OrderModel orderModel) {
        orderJpaRepository.save(orderEntityMapper.toEntity(orderModel));
    }

    @Override
    public List<OrderModel> getAllOrderWithPagination(Long restaurantId,Long employeeId,Integer page, Integer size, String state) {
        PageRequest pageRequest = PageRequest.of(page,size);
        Page<OrderEntity> orderEntityPage = orderJpaRepository.getAllOrderWithPagination(restaurantId,employeeId,state,pageRequest);
        return orderEntityPage.stream().map(orderEntityMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Boolean existOrderBYCustomerAndState(Long customerId, List<String> state) {
        return orderJpaRepository.existOrderBYCustomerAndState(customerId,state);
    }

    @Override
    public Optional<OrderModel> findOrderByIdAndState(Long orderId, String state) {
        Optional<OrderEntity> orderEntity = orderJpaRepository.findOrderByIdAndState(orderId,state);
        if(!orderEntity.isPresent()){
            return Optional.empty();
        }
        return Optional.ofNullable(orderEntityMapper.toModel(orderEntity.get()));
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
