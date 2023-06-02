package com.xebia.inventoryservice.controller;

import com.xebia.inventoryservice.dto.InventoryResponse;
import com.xebia.inventoryservice.service.IInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping()
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return iInventoryService.isInStock(skuCode);
    }

}
