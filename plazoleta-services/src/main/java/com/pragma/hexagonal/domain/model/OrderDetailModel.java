package com.pragma.hexagonal.domain.model;

public class OrderDetailModel {
    private Long id;
    private DishModel dish;
    private Long amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DishModel getDish() {
        return dish;
    }

    public void setDish(DishModel dish) {
        this.dish = dish;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
