package com.pragma.hexagonal.domain.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class OrderModel {
    private Long id;
    private Long customerId;
    private LocalDate createAt;
    private String state;
    private RestaurantEmployeeModel restaurantEmployee;
    private RestaurantModel restaurant;
    private Set<OrderDetails> dishes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public RestaurantModel getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantModel restaurant) {
        this.restaurant = restaurant;
    }

    public Set<OrderDetails> getDishes() {
        return dishes;
    }

    public void setDishes(Set<OrderDetails> dishes) {
        this.dishes = dishes;
    }

    public RestaurantEmployeeModel getRestaurantEmployee() {
        return restaurantEmployee;
    }

    public void setRestaurantEmployee(RestaurantEmployeeModel restaurantEmployee) {
        this.restaurantEmployee = restaurantEmployee;
    }
}
