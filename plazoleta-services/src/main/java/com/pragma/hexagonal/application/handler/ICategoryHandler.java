package com.pragma.hexagonal.application.handler;

import com.pragma.hexagonal.application.dto.request.CategoryRequestDto;
import com.pragma.hexagonal.application.dto.response.CategoryResponseDto;

import java.util.List;

public interface ICategoryHandler {
    void save(CategoryRequestDto categoryRequestDto);
    CategoryResponseDto getCategoryById(Long id);
    List<CategoryResponseDto> getAllCategories();
    void deleteCategoryById(Long id);
}
