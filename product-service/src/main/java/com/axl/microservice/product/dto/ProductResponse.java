package com.axl.microservice.product.dto;

import java.math.BigDecimal;

public record ProductResponse(Integer id, String name, String description,String skuCode, BigDecimal price) {
}
