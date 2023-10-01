package com.ecommerce.ecommercestore.expose.web;

import com.ecommerce.ecommercestore.application.dto.billboard.BillboardDto;
import com.ecommerce.ecommercestore.application.dto.billboard.BillboardSaveDto;
import com.ecommerce.ecommercestore.application.dto.category.CategoryDto;
import com.ecommerce.ecommercestore.application.service.BillboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/billboard")
@RequiredArgsConstructor
@RestController
public class BillboardController {
    private final BillboardService billboardService;

    @GetMapping
    public ResponseEntity<List<BillboardDto>> findAll(){
        List<BillboardDto> billboards = billboardService.findAll();

        return ResponseEntity.ok(billboards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillboardDto> findById(@PathVariable("id") Long id){
        BillboardDto billboard = billboardService.findById(id);

        return ResponseEntity.ok(billboard);
    }

    @PostMapping
    public ResponseEntity<BillboardDto> create(@RequestBody BillboardSaveDto billboardSaveDto){
        BillboardDto billboard = billboardService.create(billboardSaveDto);

        return ResponseEntity.ok((billboard));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillboardDto> edit(@PathVariable("id") Long id, @RequestBody BillboardSaveDto billboardSaveDto){
        BillboardDto billboard = billboardService.edit(id,billboardSaveDto);

        return ResponseEntity.ok(billboard);
    }
}
