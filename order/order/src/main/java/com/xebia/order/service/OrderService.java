package com.xebia.order.service;

import com.xebia.order.dto.OrderListItemsDto;
import com.xebia.order.dto.OrderRequest;
import com.xebia.order.model.Order;
import com.xebia.order.model.OrderLineItems;
import com.xebia.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author saran saravanan
 * @version 1.0
 * @since 18/05/2023
 */
@Service
@Slf4j
public class OrderService implements IOrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order placeOrder(OrderRequest request) {

        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = request.getOrderListItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);

        return orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderListItemsDto orderListItemsDto) {
        OrderLineItems orderLineItems=new OrderLineItems();
        orderLineItems.setSkuCode(orderListItemsDto.getSkuCode());
        orderLineItems.setPrice(orderListItemsDto.getPrice());
        orderLineItems.setQuantity(orderListItemsDto.getQuantity());
        return orderLineItems;
    }
}
