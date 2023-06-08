package com.pragma.hexagonal.domain.port.in;

import com.pragma.hexagonal.domain.model.DishModel;

import java.util.List;
import java.util.Optional;

public interface IDishServicePort {
    void save(DishModel dishModel);
    void update(Long id, DishModel dishModel);
    void dishUpdateEnableOrDisable(Long id,Boolean enable);
    List<DishModel> getAllDishByRestaurantId(Long restaurantId,Integer page,Integer size);
    Optional<DishModel> getDishById(Long id);
    List<DishModel> getAllDishes();
}
