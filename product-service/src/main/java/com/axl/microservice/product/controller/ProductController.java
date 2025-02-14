package com.axl.microservice.product.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.axl.microservice.product.dto.ProductRequest;
import com.axl.microservice.product.dto.ProductResponse;
import com.axl.microservice.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(
            @RequestBody ProductRequest request
    ) {
        return ResponseEntity.ok(service.createProduct(request));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return ResponseEntity.ok(service.getAllProducts());
    }
}
