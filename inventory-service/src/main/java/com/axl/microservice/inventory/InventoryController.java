package com.axl.microservice.inventory;

import com.axl.microservice.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<Boolean> isInStock(
            @RequestParam String skuCode,
            @RequestParam Integer quantity
    ){
        return ResponseEntity.ok(inventoryService.isInStock(skuCode,quantity));
    }
}
