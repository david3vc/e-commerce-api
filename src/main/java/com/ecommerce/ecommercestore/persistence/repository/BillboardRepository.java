package com.ecommerce.ecommercestore.persistence.repository;

import com.ecommerce.ecommercestore.persistence.entity.Billboard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BillboardRepository extends CrudRepository<Billboard, Long> {
    List<Billboard> findByState(String state);
}
