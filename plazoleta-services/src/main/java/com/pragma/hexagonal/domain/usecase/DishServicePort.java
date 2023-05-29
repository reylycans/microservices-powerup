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
       DishModel dishResult = getDishById(id);
       if(dishResult==null){
           throw new DishDomainException("dish does not exist to update");
       }
       dishResult.setDescription(dishModel.getDescription());
       dishResult.setPrice(dishModel.getPrice());
       dishRepository.update(dishResult);
    }

    @Override
    public void updateEnableOrDisableDish(Long id, boolean flag) {

    }

    @Override
    public DishModel getDishById(Long id) {
        Optional<DishModel> dishModel = dishRepository.getDishById(id);
        return dishModel.get();
    }

    @Override
    public List<DishModel> getAllDishes() {
        return null;
    }
}
