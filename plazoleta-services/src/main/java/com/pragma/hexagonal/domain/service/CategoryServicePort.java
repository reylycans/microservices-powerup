package com.pragma.hexagonal.domain.service;

import com.pragma.hexagonal.domain.enums.MessageErrorEnum;
import com.pragma.hexagonal.domain.exception.CategoryDomainException;
import com.pragma.hexagonal.domain.model.CategoryModel;
import com.pragma.hexagonal.domain.port.in.ICategoryServicePort;
import com.pragma.hexagonal.domain.port.out.ICategoryRepository;

import java.util.List;
import java.util.Optional;

public class CategoryServicePort implements ICategoryServicePort {

    private final ICategoryRepository categoryRepository;

    public CategoryServicePort(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(CategoryModel categoryModel) {
       if(categoryRepository.getCategoryByName(categoryModel.getName()).isPresent()){
           throw new CategoryDomainException(MessageErrorEnum.CATEGORY_SAVE.getValue());
       }
       categoryRepository.save(categoryModel);
    }

    @Override
    public CategoryModel getCategoryById(Long id) {
        Optional<CategoryModel> categoryModel =categoryRepository.getCategoryById(id);
        if(!categoryModel.isPresent()){
            throw new CategoryDomainException(MessageErrorEnum.CATEGORY_NOT_FOUND.getValue());
        }
        return categoryModel.get();
    }

    @Override
    public List<CategoryModel> getAllCategories() {
        return null;
    }

    @Override
    public void deleteCategoryById(Long id) {

    }
}
