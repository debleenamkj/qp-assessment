package com.qpassessment.grocery.booking.controller;

import com.qpassessment.grocery.booking.model.GroceryItem;
import com.qpassessment.grocery.booking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/items")
public class AdminController {

    @Autowired
    private AdminService groceryItemService;

    @GetMapping
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemService.getAllGroceryItems();
    }

    @PostMapping
    public ResponseEntity<GroceryItem> addGroceryItem(@RequestBody GroceryItem groceryItem) {
        GroceryItem addedItem = groceryItemService.addGroceryItem(groceryItem);
        return ResponseEntity.ok(addedItem);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<GroceryItem> getGroceryItemById(@PathVariable Long itemId) {
        GroceryItem groceryItem = groceryItemService.getGroceryItemById(itemId);
        return ResponseEntity.ok(groceryItem);
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable Long itemId, @RequestBody GroceryItem groceryItem) {
        groceryItem.setId(itemId);
        GroceryItem updatedItem = groceryItemService.updateGroceryItem(groceryItem);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> removeGroceryItem(@PathVariable Long itemId) {
        groceryItemService.removeGroceryItem(itemId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{itemId}/update-inventory/{newInventory}")
    public ResponseEntity<Void> updateInventory(@PathVariable Long itemId, @PathVariable int newInventory) {
        groceryItemService.updateInventory(itemId, newInventory);
        return ResponseEntity.noContent().build();
    }
}
