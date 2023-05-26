package com.pragma.hexagonal.infraestructure.port.out.adapter;

import com.pragma.hexagonal.domain.model.CategoryModel;
import com.pragma.hexagonal.domain.port.out.ICategoryRepository;

import java.util.List;

public class CategoryRepository implements ICategoryRepository {

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
