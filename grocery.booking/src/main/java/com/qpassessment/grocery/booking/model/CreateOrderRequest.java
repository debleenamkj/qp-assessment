package com.qpassessment.grocery.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
    private Long userID;
    private List<Long> itemIds;
    private List<Integer> quantities;


    public boolean isValid() {
        // Check if itemIds and quantities have the same size
        return itemIds != null && quantities != null && itemIds.size() == quantities.size();
    }
}
