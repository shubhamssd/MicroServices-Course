package com.axl.microservice.product.dto;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        String name,
        String description,
        String skuCode,
        BigDecimal price
) {
}
