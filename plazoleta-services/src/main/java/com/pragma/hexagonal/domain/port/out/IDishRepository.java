package com.pragma.hexagonal.domain.port.out;

import com.pragma.hexagonal.domain.model.DishModel;

import java.util.List;
import java.util.Optional;

public interface IDishRepository {
    void save(DishModel dishModel);
    void update(DishModel dishModel);
    void updateEnableOrDisableDish(Long id,boolean flag);
    Optional<DishModel> getDishById(Long id);
    List<DishModel> getAllDishByRestaurantId(Long restaurantId,Integer page,Integer size);
    Optional<DishModel> getDishByName(String name);
    List<DishModel> getAllDishes();
}
