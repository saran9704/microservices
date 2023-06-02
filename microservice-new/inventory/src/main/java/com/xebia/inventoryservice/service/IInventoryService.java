package com.xebia.inventoryservice.service;


import com.xebia.inventoryservice.dto.InventoryResponse;

import java.util.List;

/**
 * @author saran saravanan
 * @version 1.0
 * @since 18/05/2023
 */
public interface IInventoryService {
    List<InventoryResponse> isInStock(List<String> skuCode);
}
