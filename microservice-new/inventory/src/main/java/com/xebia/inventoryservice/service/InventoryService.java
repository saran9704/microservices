package com.xebia.inventoryservice.service;

import com.xebia.inventoryservice.dto.InventoryResponse;
import com.xebia.inventoryservice.model.Inventory;
import com.xebia.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

/**
 * @author saran saravanan
 * @version 1.0
 * @since 18/05/2023
 */
@Service

public class InventoryService implements IInventoryService{

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    @Transactional(readOnly=true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return inventoryRepository.findBySkuCodeIn(skuCode)
            .stream()
                .map(inventory ->
                        InventoryResponse
                                .builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                )
                .toList();
    }
}
