package com.pragma.hexagonal.domain.model;

import java.time.LocalDate;
import java.util.List;

public class OrderModel {
    private Long id;
    private Long customerId;
    private LocalDate createAt;
    private String state;
    private RestaurantModel restaurant;
    private List<OrderDetails> dish;

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

    public List<OrderDetails> getDish() {
        return dish;
    }

    public void setDish(List<OrderDetails> dish) {
        this.dish = dish;
    }
}
