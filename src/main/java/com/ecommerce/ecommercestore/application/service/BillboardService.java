package com.ecommerce.ecommercestore.application.service;

import com.ecommerce.ecommercestore.application.dto.billboard.BillboardDto;
import com.ecommerce.ecommercestore.application.dto.billboard.BillboardSaveDto;
import com.ecommerce.ecommercestore.application.dto.category.CategoryDto;
import com.ecommerce.ecommercestore.application.dto.category.CategorySaveDto;
import com.ecommerce.ecommercestore.application.dto.category.CategorySimpleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BillboardService {
    List<BillboardDto> findAll();
    BillboardDto findById(Long id);
    BillboardDto create(BillboardSaveDto billboardBody);
    BillboardDto edit(Long id, BillboardSaveDto billboardBody);
    BillboardDto disable(Long id);
}
