package com.ecommerce.ecommercestore.application.dto.billboard;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BillboardDto {
    private Long id;
    private Long idStore;
    private String label;
    private String imageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
