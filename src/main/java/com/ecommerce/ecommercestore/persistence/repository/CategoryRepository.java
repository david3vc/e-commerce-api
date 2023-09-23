package com.ecommerce.ecommercestore.persistence.repository;

import com.ecommerce.ecommercestore.persistence.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>, PagingAndSortingRepository<Category, Long> {
}
