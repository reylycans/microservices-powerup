package com.pragma.hexagonal.application.handler.impl;

import com.pragma.hexagonal.application.dto.request.CategoryRequestDto;
import com.pragma.hexagonal.application.dto.response.CategoryResponseDto;
import com.pragma.hexagonal.application.handler.ICategoryHandler;
import com.pragma.hexagonal.application.mapper.request.ICategoryRequestMapper;
import com.pragma.hexagonal.application.mapper.response.ICategoryResponseMapper;
import com.pragma.hexagonal.domain.model.CategoryModel;
import com.pragma.hexagonal.domain.port.in.ICategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryHandler implements ICategoryHandler {

    private final ICategoryRequestMapper categoryRequestMapper;
    private final ICategoryResponseMapper categoryResponseMapper;
    private final ICategoryServicePort categoryServicePort;

    @Override
    public void save(CategoryRequestDto categoryRequestDto) {
        CategoryModel categoryModel = categoryRequestMapper.toCategory(categoryRequestDto);
        categoryServicePort.save(categoryModel);
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {
        return categoryResponseMapper.toResponse(categoryServicePort.getCategoryById(id));
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryResponseMapper.toResponseList(categoryServicePort.getAllCategories());
    }

    @Override
    public void deleteCategoryById(Long id) {
       categoryServicePort.deleteCategoryById(id);
    }
}
