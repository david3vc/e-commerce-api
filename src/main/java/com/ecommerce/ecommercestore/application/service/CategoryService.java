package com.ecommerce.ecommercestore.application.service;

import com.ecommerce.ecommercestore.application.dto.category.CategoryDto;
import com.ecommerce.ecommercestore.application.dto.category.CategorySaveDto;
import com.ecommerce.ecommercestore.application.dto.category.CategorySimpleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();
    CategoryDto findById(Long id);
    CategoryDto create(CategorySaveDto categoryBody);
    CategoryDto edit(Long id, CategorySaveDto categoryBody);
    CategoryDto disable(Long id);
    List<CategorySimpleDto> select();
    Page<CategoryDto> pagination(Pageable pageable);
}
