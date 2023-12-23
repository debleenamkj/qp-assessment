package com.qpassessment.grocery.booking.repository;

import com.qpassessment.grocery.booking.model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
}
