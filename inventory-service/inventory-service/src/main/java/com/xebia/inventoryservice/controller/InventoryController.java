package com.xebia.inventoryservice.controller;

import com.xebia.inventoryservice.service.IInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author saran saravanan
 * @version 1.0
 * @since 18/05/2023
 */
@RestController
@RequestMapping(path = "/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final IInventoryService iInventoryService;
    @GetMapping(path = "{sku-code}")
    public Boolean isInStock(@PathVariable("sku-code") String skuCode){
        return iInventoryService.isInStock(skuCode);
    }

}
