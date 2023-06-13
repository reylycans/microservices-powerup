package com.pragma.hexagonal.infraestructure.port.out.repository;

import com.pragma.hexagonal.infraestructure.port.out.entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IOrderJpaRepository extends JpaRepository<OrderEntity,Long> {

    @Query(value = "SELECT CASE WHEN max(o.order_id) > 0 then 'true' else 'false' end result " +
           "FROM pragma.orders o " +
           "WHERE o.customer_id =:customerId and o.state in(:state)",nativeQuery = true)
    Boolean existOrderBYCustomerAndState(@Param("customerId") Long customerId,
                                         @Param("state")  List<String> state);

    @Query(value = "SELECT * " +
            "FROM pragma.orders a join pragma.orders_dish_detail b on " +
            "     a.order_id = b.order_id join pragma.order_detail c on " +
            "     b.order_detail_id = c.order_detail_id join pragma.restaurant_employee d on " +
            "     a.restaurant_id = d.restaurant_id " +
            "WHERE a.restaurant_id = :restaurantId and d.user_id = :employeeId and a.state=:state ",nativeQuery = true)
    Page<OrderEntity> getAllOrderWithPagination(@Param("restaurantId") Long restaurantId,
                                                @Param("employeeId") Long employeeId,
                                                @Param("state") String state,
                                                @Param("pageable") Pageable pageable);

    @Query("SELECT o FROM OrderEntity o WHERE o.id=:orderId and o.state=:state")
    Optional<OrderEntity> findOrderByIdAndState(@Param("orderId") Long orderId,@Param("state") String state);


}
