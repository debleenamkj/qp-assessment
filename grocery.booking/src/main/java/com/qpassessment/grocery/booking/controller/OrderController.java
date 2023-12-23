package com.qpassessment.grocery.booking.controller;

import com.qpassessment.grocery.booking.model.CreateOrderRequest;
import com.qpassessment.grocery.booking.model.Order;
import com.qpassessment.grocery.booking.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest request) {

        // Validate the order request
        if (!request.isValid()) {
            return ResponseEntity.badRequest().body("Invalid order request: itemIds and quantities must have the same size.");
        }
        try {
            Order order = orderService.createOrder(request);
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();

            // Return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing the order. Please try again.");
        }
    }

}
