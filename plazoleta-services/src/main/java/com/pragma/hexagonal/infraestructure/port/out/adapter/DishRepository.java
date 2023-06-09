package com.pragma.hexagonal.infraestructure.port.out.adapter;

import com.pragma.hexagonal.domain.model.DishModel;
import com.pragma.hexagonal.domain.port.out.IDishRepository;
import com.pragma.hexagonal.infraestructure.port.out.entity.DishEntity;
import com.pragma.hexagonal.infraestructure.port.out.mapper.IDishEntityMapper;
import com.pragma.hexagonal.infraestructure.port.out.repository.IDishJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class DishRepository implements IDishRepository {

    private final IDishJpaRepository dishJpaRepository;
    private final IDishEntityMapper dishEntityMapper;

    @Override
    public void save(DishModel dishModel) {
        dishJpaRepository.save(dishEntityMapper.toEntity(dishModel));
    }

    @Override
    public void update(DishModel dishModel) {
        dishJpaRepository.save(dishEntityMapper.toEntity(dishModel));
    }

    @Override
    public void updateEnableOrDisableDish(Long id, boolean flag) {

    }

    @Override
    public Optional<DishModel> getDishById(Long id) {
        Optional<DishEntity> dishEntity = dishJpaRepository.findById(id);
        if(!dishEntity.isPresent()){
            return Optional.empty();
        }
        return Optional.ofNullable(dishEntityMapper.toModel(dishEntity.get()));
    }

    @Override
    public List<DishModel> getAllDishByRestaurantId(Long restaurantId, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size, Sort.by("category"));
        return dishJpaRepository.findAllByRestaurantId(restaurantId,pageable)
                .stream().map(dishEntityMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Optional<DishModel> getDishByName(String name) {
        Optional<DishEntity> dishEntity = dishJpaRepository.findOneByName(name);
        if(!dishEntity.isPresent()){
            return Optional.empty();
        }
        return Optional.ofNullable(dishEntityMapper.toModel(dishEntity.get()));
    }

    @Override
    public List<DishModel> getAllDishes() {
        return null;
    }
}
