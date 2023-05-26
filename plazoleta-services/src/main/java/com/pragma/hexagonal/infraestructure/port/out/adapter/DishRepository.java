package com.pragma.hexagonal.infraestructure.port.out.adapter;

import com.pragma.hexagonal.domain.model.DishModel;
import com.pragma.hexagonal.domain.port.out.IDishRepository;

import java.util.List;

public class DishRepository implements IDishRepository {

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
