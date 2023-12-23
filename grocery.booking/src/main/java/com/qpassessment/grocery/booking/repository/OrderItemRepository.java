package com.qpassessment.grocery.booking.repository;

import com.qpassessment.grocery.booking.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}