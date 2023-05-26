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

    private final ICategoryRequestMapper iCategoryRequestMapper;
    private final ICategoryResponseMapper iCategoryResponseMapper;
    private final ICategoryServicePort iCategoryServicePort;

    @Override
    public void save(CategoryRequestDto categoryRequestDto) {
        CategoryModel categoryModel = iCategoryRequestMapper.toCategory(categoryRequestDto);
        iCategoryServicePort.save(categoryModel);
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {
        return iCategoryResponseMapper.toResponse(iCategoryServicePort.getCategoryById(id));
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return iCategoryResponseMapper.toResponseList(iCategoryServicePort.getAllCategories());
    }

    @Override
    public void deleteCategoryById(Long id) {
       iCategoryServicePort.deleteCategoryById(id);
    }
}
