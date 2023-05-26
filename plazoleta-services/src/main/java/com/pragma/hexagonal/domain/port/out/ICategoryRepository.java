package com.pragma.hexagonal.domain.port.out;

import com.pragma.hexagonal.domain.model.CategoryModel;

import java.util.List;

public interface ICategoryRepository {
    void save(CategoryModel categoryModel);
    CategoryModel getCategoryById(Long id);
    List<CategoryModel> getAllCategories();
    void deleteCategoryById(Long id);
}
