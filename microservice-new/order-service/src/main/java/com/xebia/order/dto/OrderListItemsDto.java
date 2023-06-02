package com.xebia.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author saran saravanan
 * @version 1.0
 * @since 18/05/2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderListItemsDto {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
