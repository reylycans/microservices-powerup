package com.pragma.hexagonal.factory;

import com.pragma.hexagonal.domain.model.CategoryModel;

public class CategoryFactoryDataTest {

    public static CategoryModel getCategory(){
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(1L);
        categoryModel.setName("arroz chino");
        categoryModel.setDescription("categoria arroz chino");

        return categoryModel;
    }
}
