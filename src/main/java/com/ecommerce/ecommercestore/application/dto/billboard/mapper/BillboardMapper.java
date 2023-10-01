package com.ecommerce.ecommercestore.application.dto.billboard.mapper;

import com.ecommerce.ecommercestore.application.dto.billboard.BillboardDto;
import com.ecommerce.ecommercestore.application.dto.billboard.BillboardSaveDto;
import com.ecommerce.ecommercestore.application.dto.billboard.BillboardSimpleDto;
import com.ecommerce.ecommercestore.persistence.entity.Billboard;
import com.ecommerce.ecommercestore.shared.state.mapper.StateMapper;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {StateMapper.class})
public interface BillboardMapper {
    // Dto from Entity start
    @Mapping(target = "id", source = "id")
    @Mapping(target = "idStore", source = "idStore")
    @Mapping(target = "label", source = "label")
    @Mapping(target = "imageUrl", source = "imageUrl")
    @Mapping(target = "state", source = "state")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    BillboardDto toBillboardDto(Billboard billboard);
    List<BillboardDto> toBillboardDtos(List<Billboard> billboards);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "label", source = "label")
    List<BillboardSimpleDto> toBillboardSimpleDtos(List<Billboard> billboards);
    // Entity to Dto end

    // Entity from Dto start
    @Mapping(target = "label", source = "label")
    @Mapping(target = "imageUrl", source = "imageUrl")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idStore", ignore = true)
    @Mapping(target = "state", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Billboard toBillboard(BillboardSaveDto billboardSaveDto);
    @InheritConfiguration
    void updateBillboard(@MappingTarget Billboard billboard, BillboardSaveDto billboardSaveDto);
    // Entity from Dto end
}
