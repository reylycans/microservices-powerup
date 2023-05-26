package com.pragma.hexagonal.domain.usecase;

import com.pragma.hexagonal.domain.model.CategoryModel;
import com.pragma.hexagonal.domain.port.in.ICategoryServicePort;
import com.pragma.hexagonal.domain.port.out.ICategoryRepository;

import java.util.List;

public class CategoryServicePort implements ICategoryServicePort {

    private final ICategoryRepository categoryRepository;

    public CategoryServicePort(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(CategoryModel categoryModel) {

    }

    @Override
    public CategoryModel getCategoryById(Long id) {
        return null;
    }

    @Override
    public List<CategoryModel> getAllCategories() {
        return null;
    }

    @Override
    public void deleteCategoryById(Long id) {

    }
}
