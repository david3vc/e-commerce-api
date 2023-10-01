package com.ecommerce.ecommercestore.persistence.repository;

import com.ecommerce.ecommercestore.persistence.entity.Billboard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BillboardRepository extends CrudRepository<Billboard, Long> {
}
