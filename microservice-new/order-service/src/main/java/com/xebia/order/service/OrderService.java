package com.xebia.order.service;

import com.xebia.order.dto.InventoryResponse;
import com.xebia.order.dto.OrderListItemsDto;
import com.xebia.order.dto.OrderRequest;
import com.xebia.order.model.Order;
import com.xebia.order.model.OrderLineItems;
import com.xebia.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
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
    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public Order placeOrder(OrderRequest request) {

        log.info("order placing");
        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = request.getOrderListItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);

        List<String> skuCodeList = order.getOrderLineItemsList()
                .stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

//        calling inventory service to check the
//        product is present or not in a stock

        InventoryResponse[] inventoryResponses = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode",skuCodeList)
                                .build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        assert inventoryResponses != null;
        if((long) skuCodeList.size() == Arrays.stream(inventoryResponses).count()){
            log.info("response ={}", Arrays.stream(inventoryResponses).toList().toString());

            boolean allProductIsInStock = Arrays.stream(inventoryResponses)
                    .allMatch(InventoryResponse::getIsInStock);

            if(allProductIsInStock){
                return orderRepository.save(order);
            }else {
                throw new IllegalArgumentException("Product is not in stock, please try again");
            }
        }else {
            throw new IllegalArgumentException("Product is not in stock, please try again");
        }






    }

    private OrderLineItems mapToDto(OrderListItemsDto orderListItemsDto) {
        OrderLineItems orderLineItems=new OrderLineItems();
        orderLineItems.setSkuCode(orderListItemsDto.getSkuCode());
        orderLineItems.setPrice(orderListItemsDto.getPrice());
        orderLineItems.setQuantity(orderListItemsDto.getQuantity());
        return orderLineItems;
    }
}
