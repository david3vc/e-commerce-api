package com.ecommerce.ecommercestore.application.service.impl;

import com.ecommerce.ecommercestore.application.dto.billboard.BillboardDto;
import com.ecommerce.ecommercestore.application.dto.billboard.BillboardSaveDto;
import com.ecommerce.ecommercestore.application.dto.billboard.BillboardSimpleDto;
import com.ecommerce.ecommercestore.application.dto.billboard.mapper.BillboardMapper;
import com.ecommerce.ecommercestore.application.dto.category.CategorySimpleDto;
import com.ecommerce.ecommercestore.application.service.BillboardService;
import com.ecommerce.ecommercestore.persistence.entity.Billboard;
import com.ecommerce.ecommercestore.persistence.repository.BillboardRepository;
import com.ecommerce.ecommercestore.shared.state.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BillboardServiceImpl implements BillboardService {
    private final BillboardRepository billboardRepository;
    private final BillboardMapper billboardMapper;
    @Override
    public List<BillboardDto> findAll() {
        List<Billboard> billboards = (List<Billboard>) billboardRepository.findAll();
        return billboardMapper.toBillboardDtos(billboards);
    }

    @Override
    public BillboardDto findById(Long id) {
        Billboard billboard = billboardRepository.findById(id).get();
        return billboardMapper.toBillboardDto(billboard);
    }

    @Override
    public BillboardDto create(BillboardSaveDto billboardBody) {
        Billboard billboardSave = billboardMapper.toBillboard(billboardBody);
        billboardSave.setState(State.ACTIVE.getValue());
        billboardSave.setCreatedAt(LocalDateTime.now());

        Billboard billboard = billboardRepository.save(billboardSave);
        return billboardMapper.toBillboardDto(billboard);
    }

    @Override
    public BillboardDto edit(Long id, BillboardSaveDto billboardBody) {
        Billboard billboardDb = billboardRepository.findById(id).get();

        billboardMapper.updateBillboard(billboardDb, billboardBody);
        billboardDb.setUpdatedAt(LocalDateTime.now());

        Billboard billboard = billboardRepository.save(billboardDb);

        return billboardMapper.toBillboardDto(billboard);
    }

    @Override
    public BillboardDto disable(Long id) {
        Billboard billboardDb = billboardRepository.findById(id).get();

        billboardDb.setState(State.DISABLE.getValue());

        Billboard billboard = billboardRepository.save(billboardDb);

        return billboardMapper.toBillboardDto(billboard);
    }

    @Override
    public List<BillboardSimpleDto> select() {
        List<Billboard> billboard = billboardRepository.findByState(State.ACTIVE.getValue());
        return billboardMapper.toBillboardSimpleDtos(billboard);
    }
}
