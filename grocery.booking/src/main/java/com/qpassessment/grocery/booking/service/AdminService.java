package com.qpassessment.grocery.booking.service;

import com.qpassessment.grocery.booking.model.GroceryItem;
import com.qpassessment.grocery.booking.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    
    public GroceryItem addGroceryItem(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    
    public GroceryItem getGroceryItemById(Long itemId) {
        return groceryItemRepository.findById(itemId).orElse(null);
    }

    
    public GroceryItem updateGroceryItem(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    
    public void removeGroceryItem(Long itemId) {
        groceryItemRepository.deleteById(itemId);
    }

    
    public void updateInventory(Long itemId, int newInventory) {
        Optional<GroceryItem> optionalGroceryItem = groceryItemRepository.findById(itemId);
        optionalGroceryItem.ifPresent(groceryItem -> {
            groceryItem.setInventory(newInventory);
            groceryItemRepository.save(groceryItem);
        });
    }
}
