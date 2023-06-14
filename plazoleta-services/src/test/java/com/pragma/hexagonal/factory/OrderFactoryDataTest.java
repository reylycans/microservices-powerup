package com.pragma.hexagonal.factory;

import com.pragma.hexagonal.domain.enums.StateEnum;
import com.pragma.hexagonal.domain.model.OrderDetailModel;
import com.pragma.hexagonal.domain.model.OrderModel;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderFactoryDataTest {

    public static OrderModel getOrder(){
        OrderModel orderModel = new OrderModel();
        orderModel.setCustomerId(24L);
        orderModel.setRestaurant(RestaurantFactoryDataTest.getRestaurant());
        orderModel.setDishes(getDishes());

        return orderModel;
    }

    public static List<OrderModel> getOrderList(){
        OrderModel orderModel = new OrderModel();
        List<OrderModel> orderModelList = new ArrayList<>();
        orderModel.setCustomerId(24L);
        orderModel.setRestaurant(RestaurantFactoryDataTest.getRestaurant());
        orderModel.setDishes(getDishes());

        orderModelList.add(orderModel);

        return orderModelList;
    }

    public static List<String> OrderStatus(){
        List<String> states = List.of(StateEnum.PENDING.toString(),
                StateEnum.READY.toString(),StateEnum.PREPARATION.toString());
        return states;
    }

    public static Set<OrderDetailModel> getDishes(){
        Set<OrderDetailModel> orderDetailsSet = new HashSet<>();
        OrderDetailModel orderDetails = new OrderDetailModel();
        orderDetails.setDish(DishFactoryDataTest.getDish());
        orderDetails.setAmount(5L);
        orderDetailsSet.add(orderDetails);

        return orderDetailsSet;
    }
}
