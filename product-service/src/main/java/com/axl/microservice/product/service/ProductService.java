package com.axl.microservice.product.service;

import com.axl.microservice.product.dto.ProductRequest;
import com.axl.microservice.product.dto.ProductResponse;
import com.axl.microservice.product.model.Product;
import com.axl.microservice.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.name())
                .description(request.description())
                .skuCode(request.skuCode())
                .price(request.price())
                .build();
        productRepository.save(product);
        log.info("Product successfully created");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(),
                product.getSkuCode(), product.getPrice());

    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(),
                        product.getSkuCode(), product.getPrice()))
                .toList();
    }
}
