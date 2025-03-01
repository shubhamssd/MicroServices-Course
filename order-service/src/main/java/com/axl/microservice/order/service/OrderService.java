package com.axl.microservice.order.service;

import com.axl.microservice.order.client.InventoryClient;
import com.axl.microservice.order.dto.OrderRequest;
import com.axl.microservice.order.model.Order;
import com.axl.microservice.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;


    public String placeOrder(OrderRequest request, String orderPlacedSuccessfully) {
        var isProductInStock = inventoryClient.isInStock(request.skuCode(), request.quantity());

        if (isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(request.price());
            order.setSkuCode(request.skuCode());
            order.setQuantity(request.quantity());

            Order placedOrder = orderRepository.save(order);
            return placedOrder + "orders placed";

        }else {
            throw new RuntimeException("Product with SkuCode " + request.skuCode() + "is not in stock" );
        }
    }
}
