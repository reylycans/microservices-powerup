package com.pragma.hexagonal.infraestructure.port.out.adapter;

import com.pragma.hexagonal.domain.model.CategoryModel;
import com.pragma.hexagonal.domain.port.out.ICategoryRepository;
import com.pragma.hexagonal.infraestructure.port.out.entity.CategoryEntity;
import com.pragma.hexagonal.infraestructure.port.out.mapper.ICategoryEntityMapper;
import com.pragma.hexagonal.infraestructure.port.out.repository.ICategoryJpaRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CategoryRepository implements ICategoryRepository {

    private final ICategoryJpaRepository categoryJpaRepository;
    private final ICategoryEntityMapper categoryEntityMapper;
    @Override
    public void save(CategoryModel categoryModel) {
        categoryJpaRepository.save(categoryEntityMapper.toEntity(categoryModel));
    }

    @Override
    public Optional<CategoryModel> getCategoryById(Long id) {
        Optional<CategoryEntity> categoryEntity = categoryJpaRepository.findById(id);
        if(!categoryEntity.isPresent()){
            return Optional.empty();
        }
        return Optional.ofNullable(categoryEntityMapper.toModel(categoryEntity.get()));
    }

    @Override
    public Optional<CategoryModel> getCategoryByName(String name) {
        Optional<CategoryEntity> categoryEntity = categoryJpaRepository.findOneByName(name);
        if(!categoryEntity.isPresent()){
            return Optional.empty();
        }
        return Optional.ofNullable(categoryEntityMapper.toModel(categoryEntity.get()));
    }

    @Override
    public List<CategoryModel> getAllCategories() {
        return null;
    }

    @Override
    public void deleteCategoryById(Long id) {

    }
}
