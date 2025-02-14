package com.axl.microservice.order.dto;

import java.math.BigDecimal;

public record OrderRequest(
        Integer id, String orderNumber, String skuCode, BigDecimal price, Integer quantity
) {
}
