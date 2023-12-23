package com.qpassessment.grocery.booking.service;

import com.qpassessment.grocery.booking.model.CreateOrderRequest;
import com.qpassessment.grocery.booking.model.GroceryItem;
import com.qpassessment.grocery.booking.model.Order;
import com.qpassessment.grocery.booking.model.OrderItem;
import com.qpassessment.grocery.booking.repository.GroceryItemRepository;
import com.qpassessment.grocery.booking.repository.OrderItemRepository;
import com.qpassessment.grocery.booking.repository.OrderRepository;
import com.qpassessment.grocery.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderItemRepository orderItemRepository;
    private final GroceryItemRepository groceryItemRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository, OrderItemRepository orderItemRepository, GroceryItemRepository groceryItemRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderItemRepository = orderItemRepository;
        this.groceryItemRepository = groceryItemRepository;
    }

    public Order createOrder(CreateOrderRequest request) {
        Long userID = request.getUserID();
        List<Long> itemIds = request.getItemIds();
        List<Integer> quantities = request.getQuantities();

        Order order = new Order();
        order.setUser(userRepository.findById(userID).orElseThrow());
        order.setOrderDate(LocalDateTime.now());

        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0.0;

        for (int i = 0; i < itemIds.size(); i++) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);

            GroceryItem groceryItem = groceryItemRepository.findById(itemIds.get(i)).orElseThrow();
            orderItem.setGroceryItem(groceryItem);

            int quantity = quantities.get(i);
            orderItem.setQuantity(quantity);

            double subtotal = groceryItem.getPrice() * quantity;
            orderItem.setSubtotal(subtotal);

            total += subtotal;
            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        order.setTotal(total);

        return orderRepository.save(order);
    }
}
