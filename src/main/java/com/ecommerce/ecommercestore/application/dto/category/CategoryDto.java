package com.ecommerce.ecommercestore.application.dto.category;

import com.ecommerce.ecommercestore.shared.state.enums.State;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CategoryDto {
    private Long id;
    private Long idStore;
    private Long idBillboard;
    private String name;
    private State state;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
