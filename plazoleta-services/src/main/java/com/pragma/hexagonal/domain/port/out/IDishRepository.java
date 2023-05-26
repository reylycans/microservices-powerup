package com.pragma.hexagonal.domain.port.out;

import com.pragma.hexagonal.domain.model.DishModel;

import java.util.List;

public interface IDishRepository {
    void save(DishModel dishModel);
    void update(Long id, DishModel dishModel);
    void updateEnableOrDisableDish(Long id,boolean flag);
    DishModel getDishById(Long id);
    List<DishModel> getAllDishes();
}
