package com.ecommerce.ecommercestore.application.service.impl;

import com.ecommerce.ecommercestore.application.dto.category.CategoryDto;
import com.ecommerce.ecommercestore.application.dto.category.CategorySaveDto;
import com.ecommerce.ecommercestore.application.dto.category.CategorySimpleDto;
import com.ecommerce.ecommercestore.application.dto.category.mapper.CategoryMapper;
import com.ecommerce.ecommercestore.application.service.CategoryService;
import com.ecommerce.ecommercestore.persistence.entity.Category;
import com.ecommerce.ecommercestore.persistence.repository.CategoryRepository;
import com.ecommerce.ecommercestore.shared.state.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        List<CategoryDto> categoryDtos = categoryMapper.toCategoryDtos(categories);

        return categoryDtos;
    }

    @Override
    public CategoryDto findById(Long id) {
        Category category = categoryRepository.findById(id).get();
        CategoryDto categoryDto = categoryMapper.toCategoryDto(category);

        return categoryDto;
    }

    @Override
    public CategoryDto create(CategorySaveDto categoryBody) {
        Category categorySave = categoryMapper.toCategory(categoryBody);

        categorySave.setState(State.ACTIVE.getValue());
        categorySave.setCreatedAt(LocalDateTime.now());

        Category category = categoryRepository.save(categorySave);

        return categoryMapper.toCategoryDto(category);
    }

    @Override
    public CategoryDto edit(Long id, CategorySaveDto categoryBody) {
        Category categoryDb = categoryRepository.findById(id).get();

        categoryMapper.updateCategory(categoryDb, categoryBody);
        categoryDb.setUpdatedAt(LocalDateTime.now());

        Category category = categoryRepository.save(categoryDb);

        return categoryMapper.toCategoryDto(category);
    }

    @Override
    public CategoryDto disable(Long id) {
        Category categoryDb = categoryRepository.findById(id).get();

        categoryDb.setState(State.DISABLE.getValue());

        Category category = categoryRepository.save(categoryDb);

        return categoryMapper.toCategoryDto(category);
    }

    @Override
    public List<CategorySimpleDto> select() {
        List<Category> categories = categoryRepository.findByState(State.ACTIVE.getValue());
        return categoryMapper.toCategorySimpleDtos(categories);
    }

    @Override
    public Page<CategoryDto> pagination(Pageable pageable) {
        Page<Category> categoryPage = categoryRepository.findAll(pageable);

        List<CategoryDto> categoryDtos = categoryMapper.toCategoryDtos(categoryPage.getContent());

        Page<CategoryDto> categoryDtoPage = new PageImpl<>(categoryDtos, categoryPage.getPageable(), categoryPage.getTotalElements());

        return categoryDtoPage;
    }
}
