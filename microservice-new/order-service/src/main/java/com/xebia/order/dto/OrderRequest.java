package com.xebia.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author saran saravanan
 * @version 1.0
 * @since 18/05/2023
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderListItemsDto> orderListItemsDtoList;
}
