package com.pragma.hexagonal.application.handler;

import com.pragma.hexagonal.application.dto.request.DishRequestDto;
import com.pragma.hexagonal.application.dto.request.DishUpdateRequestDto;
import com.pragma.hexagonal.application.dto.response.DishResponseDto;

import java.util.List;

public interface IDishHandler {
    void save(DishRequestDto dishRequestDto);
    void update(Long id, DishUpdateRequestDto dishUpdateRequestDto);
    void dishUpdateEnableOrDisable(Long id,boolean flag);
    DishResponseDto getDishById(Long id);
    List<DishResponseDto> getAllDishes();
}
