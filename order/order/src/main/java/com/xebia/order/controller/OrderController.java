package com.xebia.order.controller;

import com.xebia.order.dto.OrderRequest;
import com.xebia.order.dto.Response;
import com.xebia.order.model.Order;
import com.xebia.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author saran saravanan
 * @version 1.0
 * @since 18/05/2023
 */
@RestController
@RequestMapping(path = "/api/order")
public class OrderController {

    @Autowired
    private IOrderService iOrderService;

    @PostMapping(path = "placeOrder")
    public ResponseEntity<Response> placeOrder(@RequestBody OrderRequest request){
        Order order=iOrderService.placeOrder(request);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("order",order))
                        .message("order placed successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
