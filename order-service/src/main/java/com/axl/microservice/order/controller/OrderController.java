package com.axl.microservice.order.controller;

import com.axl.microservice.order.dto.OrderRequest;
import com.axl.microservice.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<String> placeOrder(
            @RequestBody OrderRequest request
    ){
        return ResponseEntity.ok(orderService.placeOrder(request,"Order placed successfully"));
    }
}
