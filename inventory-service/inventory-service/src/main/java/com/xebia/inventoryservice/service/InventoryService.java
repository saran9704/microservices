package com.xebia.inventoryservice.service;

import com.xebia.inventoryservice.model.Inventory;
import com.xebia.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

/**
 * @author saran saravanan
 * @version 1.0
 * @since 18/05/2023
 */
@Service
@RequiredArgsConstructor
public class InventoryService implements IInventoryService{

    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional(readOnly=true)
    public Boolean isInStock(String skuCode) {
        Optional<Inventory> bySkuCode = inventoryRepository.findBySkuCode(skuCode);
        return bySkuCode.isPresent();
    }
}
