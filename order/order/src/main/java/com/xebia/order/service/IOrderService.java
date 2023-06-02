package com.xebia.order.service;

import com.xebia.order.dto.OrderRequest;
import com.xebia.order.model.Order;

/**
 * @author saran saravanan
 * @version 1.0
 * @since 18/05/2023
 */
public interface IOrderService {
    Order placeOrder(OrderRequest request);
}
