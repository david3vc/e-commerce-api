package com.ecommerce.ecommercestore.shared.exception.entity;

import lombok.Data;

import java.util.Map;

@Data
public class ArgumentNotValidError {
    private String message;
    private Map<String, String> error;
}
