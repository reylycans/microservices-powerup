package com.pragma.hexagonal.domain.usecase;

import com.pragma.hexagonal.domain.model.DishModel;
import com.pragma.hexagonal.domain.port.in.IDishServicePort;
import com.pragma.hexagonal.domain.port.out.IDishRepository;

import java.util.List;

public class DishServicePort implements IDishServicePort {

    private final IDishRepository dishRepository;

    public DishServicePort(IDishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public void save(DishModel dishModel) {

    }

    @Override
    public void update(Long id, DishModel dishModel) {

    }

    @Override
    public void updateEnableOrDisableDish(Long id, boolean flag) {

    }

    @Override
    public DishModel getDishById(Long id) {
        return null;
    }

    @Override
    public List<DishModel> getAllDishes() {
        return null;
    }
}
