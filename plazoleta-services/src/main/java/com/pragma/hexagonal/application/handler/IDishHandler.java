package com.pragma.hexagonal.application.handler;

import com.pragma.hexagonal.application.dto.request.DishRequestDto;
import com.pragma.hexagonal.application.dto.response.DishResponseDto;

import java.util.List;

public interface IDishHandler {
    void save(DishRequestDto dishRequestDto);
    void update(Long id,DishRequestDto dishRequestDto);
    void updateEnableOrDisableDish(Long id,boolean flag);
    DishResponseDto getDishById(Long id);
    List<DishResponseDto> getAllDishes();
}
