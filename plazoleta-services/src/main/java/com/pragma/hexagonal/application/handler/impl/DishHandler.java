package com.pragma.hexagonal.application.handler.impl;

import com.pragma.hexagonal.application.dto.request.DishRequestDto;
import com.pragma.hexagonal.application.dto.request.DishUpdateRequestDto;
import com.pragma.hexagonal.application.dto.response.DishResponseDto;
import com.pragma.hexagonal.application.handler.IDishHandler;
import com.pragma.hexagonal.application.mapper.request.IDishRequestMapper;
import com.pragma.hexagonal.application.mapper.request.IDishUpdateRequestMapper;
import com.pragma.hexagonal.application.mapper.response.IDishResponseMapper;
import com.pragma.hexagonal.domain.model.DishModel;
import com.pragma.hexagonal.domain.port.in.IDishServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DishHandler implements IDishHandler {

    private final IDishServicePort dishServicePort;
    private final IDishRequestMapper dishRequestMapper;
    private final IDishResponseMapper dishResponseMapper;
    private final IDishUpdateRequestMapper dishUpdateRequestMapper;

    @Override
    public void save(DishRequestDto dishRequestDto) {
        DishModel dishModel = dishRequestMapper.toModel(dishRequestDto);
        dishModel.setAsset(Boolean.TRUE);
        dishServicePort.save(dishModel);
    }

    @Override
    public void update(Long id, DishUpdateRequestDto dishUpdateRequestDto) {
        DishModel dishModel = dishUpdateRequestMapper.toUpdateModel(dishUpdateRequestDto);
        dishServicePort.update(id,dishModel);
    }

    @Override
    public void dishUpdateEnableOrDisable(Long id, boolean flag) {
       dishServicePort.dishUpdateEnableOrDisable(id,flag);
    }

    @Override
    public List<DishResponseDto> getAllDishByRestaurantId(Long restaurantId, Integer page, Integer size) {
        return dishResponseMapper.toResponseList(dishServicePort.getAllDishByRestaurantId(restaurantId,page,size));
    }

    @Override
    public DishResponseDto getDishById(Long id) {
        return dishResponseMapper.toResponse(dishServicePort.getDishById(id));
    }

    @Override
    public List<DishResponseDto> getAllDishes() {
        return dishResponseMapper.toResponseList(dishServicePort.getAllDishes());
    }
}
