package com.ecommerce.ecommercestore.application.dto.billboard.mapper;

import com.ecommerce.ecommercestore.application.dto.billboard.BillboardDto;
import com.ecommerce.ecommercestore.application.dto.billboard.BillboardSaveDto;
import com.ecommerce.ecommercestore.application.dto.category.CategoryDto;
import com.ecommerce.ecommercestore.application.dto.category.CategorySaveDto;
import com.ecommerce.ecommercestore.application.dto.category.CategorySimpleDto;
import com.ecommerce.ecommercestore.persistence.entity.Billboard;
import com.ecommerce.ecommercestore.persistence.entity.Category;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BillboardMapper {
    // Dto from Entity start
    @Mapping(target = "id", source = "id")
    @Mapping(target = "idStore", source = "idStore")
    @Mapping(target = "label", source = "label")
    @Mapping(target = "imageUrl", source = "imageUrl")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    BillboardDto toBillboardDto(Billboard billboard);
    List<BillboardDto> toBillboardDtos(List<Billboard> billboards);
    // Entity to Dto end

    // Entity from Dto start
    @Mapping(target = "label", source = "label")
    @Mapping(target = "imageUrl", source = "imageUrl")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idStore", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Billboard toBillboard(BillboardSaveDto billboardSaveDto);
    @InheritConfiguration
    void updateBillboard(@MappingTarget Billboard billboard, BillboardSaveDto billboardSaveDto);
    // Entity from Dto end
}
