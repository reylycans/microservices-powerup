package com.pragma.hexagonal.domain.usecase;

import com.pragma.hexagonal.domain.exception.DishDomainException;
import com.pragma.hexagonal.domain.model.DishModel;
import com.pragma.hexagonal.domain.port.in.IDishServicePort;
import com.pragma.hexagonal.domain.port.out.IDishRepository;

import java.util.List;
import java.util.Optional;

public class DishServicePort implements IDishServicePort {

    private final IDishRepository dishRepository;

    public DishServicePort(IDishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public void save(DishModel dishModel) {
       if(dishRepository.getDishByName(dishModel.getName()).isPresent()){
           throw new DishDomainException("Dish already exist");
       }
       dishRepository.save(dishModel);
    }

    @Override
    public void update(Long id, DishModel dishModel) {
        Optional<DishModel> dishResult = getDishById(id);
       if(!dishResult.isPresent()){
           throw new DishDomainException("Dish does not exist to update");
       }
       dishResult.get().setDescription(dishModel.getDescription());
       dishResult.get().setPrice(dishModel.getPrice());
       dishRepository.update(dishResult.get());
    }

    @Override
    public void dishUpdateEnableOrDisable(Long id, Boolean enable) {
        Optional<DishModel> dishModel = getDishById(id);
        if(!dishModel.isPresent()){
            throw new DishDomainException("Could not enable or disable the dish because it does not exist");
        }
        dishModel.get().setAsset(enable);
        dishRepository.save(dishModel.get());
    }

    @Override
    public List<DishModel> getAllDishByRestaurantId(Long restaurantId, Integer page, Integer size) {
        return dishRepository.getAllDishByRestaurantId(restaurantId,page,size);
    }

    @Override
    public Optional<DishModel> getDishById(Long id) {
        Optional<DishModel> dishModel = dishRepository.getDishById(id);
        return dishModel;
    }

    @Override
    public List<DishModel> getAllDishes() {
        return null;
    }
}
