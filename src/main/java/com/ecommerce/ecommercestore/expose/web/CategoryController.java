package com.ecommerce.ecommercestore.expose.web;

import com.ecommerce.ecommercestore.application.dto.category.CategoryDto;
import com.ecommerce.ecommercestore.application.dto.category.CategorySaveDto;
import com.ecommerce.ecommercestore.application.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/category")
@RequiredArgsConstructor
@RestController
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    ResponseEntity<List<CategoryDto>> findAll(){
        List<CategoryDto> categories = categoryService.findAll();

        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    ResponseEntity<CategoryDto> findById(@PathVariable("id") Long id){
        CategoryDto category = categoryService.findById(id);

        return ResponseEntity.ok(category);
    }

    @PostMapping
    ResponseEntity<CategoryDto> create(@RequestBody CategorySaveDto categoryBody){
        CategoryDto category = categoryService.create(categoryBody);

        return ResponseEntity.ok(category);
    }

    @PutMapping("/{id}")
    ResponseEntity<CategoryDto> edit(@PathVariable("id") Long id, @RequestBody CategorySaveDto categoryBody){
        CategoryDto category = categoryService.edit(id, categoryBody);

        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<CategoryDto> disable(@PathVariable("id") Long id){
        CategoryDto category = categoryService.disable(id);

        return  ResponseEntity.ok(category);
    }

    @GetMapping("/pagination")
    ResponseEntity<Page<CategoryDto>> pagination(Pageable pageable){
        Page<CategoryDto> categoryPage = categoryService.pagination(pageable);

        return ResponseEntity.ok(categoryPage);
    }
}
