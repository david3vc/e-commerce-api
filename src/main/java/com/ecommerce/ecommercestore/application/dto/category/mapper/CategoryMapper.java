package com.ecommerce.ecommercestore.application.dto.category.mapper;

import com.ecommerce.ecommercestore.application.dto.category.CategoryDto;
import com.ecommerce.ecommercestore.application.dto.category.CategorySaveDto;
import com.ecommerce.ecommercestore.application.dto.category.CategorySimpleDto;
import com.ecommerce.ecommercestore.persistence.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    // Dto from Entity start
    @Mapping(target = "id", source = "id")
    @Mapping(target = "idStore", source = "idStore")
    @Mapping(target = "idBillboard", source = "idBillboard")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    CategoryDto toCategoryDto(Category category);
    List<CategoryDto> toCategoryDtos(List<Category> categories);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    CategorySimpleDto toCategorySimpleDto(Category category);
    List<CategorySimpleDto> toCategorySimpleDtos(List<Category> categories);
    // Entity to Dto end

    // Entity from Dto start
    @Mapping(target = "name", source = "name")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idStore", ignore = true)
    @Mapping(target = "idBillboard", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Category toCategory(CategorySaveDto categorySaveDto);
    // Entity from Dto end
}
