package com.qpassessment.grocery.booking.repository;

import com.qpassessment.grocery.booking.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
