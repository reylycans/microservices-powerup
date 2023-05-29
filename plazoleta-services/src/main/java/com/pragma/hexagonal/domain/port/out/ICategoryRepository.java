package com.pragma.hexagonal.domain.port.out;

import com.pragma.hexagonal.domain.model.CategoryModel;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository {
    void save(CategoryModel categoryModel);
    Optional<CategoryModel> getCategoryById(Long id);
    Optional<CategoryModel> getCategoryByName(String name);
    List<CategoryModel> getAllCategories();
    void deleteCategoryById(Long id);
}
