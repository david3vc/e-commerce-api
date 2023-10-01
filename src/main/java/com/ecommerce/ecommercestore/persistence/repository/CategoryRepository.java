package com.ecommerce.ecommercestore.persistence.repository;

import com.ecommerce.ecommercestore.persistence.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long>, PagingAndSortingRepository<Category, Long> {
    List<Category> findByState(String state);
}
