package com.om.inventory.controller;

import com.om.inventory.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("isInStock")
    public ResponseEntity<Boolean> isInStock(@RequestParam String skuCode,@RequestParam Integer quantity){
        return new ResponseEntity<>(inventoryService.isInStock(skuCode,quantity), HttpStatus.OK);
    }
}
